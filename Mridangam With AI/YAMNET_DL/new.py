import tensorflow as tf
import tensorflow_hub as hub
import numpy as np
import matplotlib.pyplot as plt
import librosa
import soundfile as sf

# Load YAMNet model from TensorFlow Hub
yamnet_model = hub.load('https://tfhub.dev/google/yamnet/1')

# Set the paths to the content and style audio files
content_path = '/content/1_01_49.wav'
style_path = '/content/7_58_49.wav'

# Load the content and style audio files
content_wave, content_sr = librosa.load(content_path)
style_wave, style_sr = librosa.load(style_path)

# Convert audio files to mono if needed
if len(content_wave.shape) > 1:
    content_wave = content_wave[:, 0]
if len(style_wave.shape) > 1:
    style_wave = style_wave[:, 0]

# Resample audio files if needed
if content_sr != 16000:
    content_wave = librosa.resample(y=content_wave, orig_sr=content_sr, target_sr=16000)
    content_sr = 16000
if style_sr != 16000:
    style_wave = librosa.resample(y=style_wave, orig_sr=style_sr, target_sr=16000)
    style_sr = 16000

# Extract audio features using YAMNet

content_features = yamnet_model(content_wave)[2]
style_features = yamnet_model(style_wave)[2]

# Define the style transfer parameters
content_weight = 2.5e-6  # Weight for content loss o=1.0. 1e-3
style_weight = 0.6e-3  # Weight for style loss o=0.01 2.6e-1
total_variation_weight = 1e-6#1e-6 # Weight for total variation loss o=30.0
num_iterations = 500#50  # Number of optimization iterations o=100

avg_len = len(content_wave)#round(np.average([len(content_wave), len(style_wave)]))
avg_len

# Initialize or generate target audio signal
# target_wave = tf.Variable(np.random.randn(avg_len).astype(np.float32) * 1e-3)
target_wave = tf.Variable(style_wave) # content actually learned the content of style

# Compute Gram matrix
def compute_gram_matrix(features):
    batch_size, num_frames, num_channels = features.shape
    features = tf.reshape(features, [batch_size, num_frames, -1])
    style_matrix = tf.matmul(features, features, transpose_a=True)
    return style_matrix / tf.cast(num_frames * num_channels, tf.float32)

# Perform optimization for audio style transfer
for iteration in range(num_iterations):
    with tf.GradientTape() as tape:
        tape.watch(target_wave)

        target_features = yamnet_model(target_wave)[2]
        
        # Compute content loss
        content_loss = tf.reduce_mean(tf.square(target_features - content_features))

        # Compute style loss using Gram matrix
        target_gram = compute_gram_matrix(tf.expand_dims(target_features, axis=0))
        style_gram = compute_gram_matrix(tf.expand_dims(style_features, axis=0))
        style_loss = tf.reduce_mean(tf.square(target_gram - style_gram))
                        
        # Compute total variation loss for smoothing
        total_variation_loss = tf.reduce_sum(tf.abs(target_wave[1:] - target_wave[:-1]))
        
        # Compute total loss
        total_loss = (
            content_weight * content_loss +
            style_weight * style_loss #+
            # total_variation_weight * total_variation_loss
        )
        if (iteration+1) % 50 == 0:
          print("Epoch {}:".format(iteration+1))
          print("Content Loss: {}, Style Loss: {}, Total Variation Loss: {}, Total Loss: {}".format(content_loss, style_loss, total_variation_loss, total_loss))
          # print("")
        
    # Compute gradients and update the target audio signal
    gradients = tape.gradient(total_loss, [target_wave])
    optimizer = tf.keras.optimizers.SGD(
    tf.keras.optimizers.schedules.ExponentialDecay(
        initial_learning_rate=25.0, decay_steps=100, decay_rate=0.86
    )
)
    optimizer.apply_gradients(zip(gradients, [target_wave]))
    
    # Clip the values to ensure they are within the valid audio range
    target_wave.assign(tf.clip_by_value(target_wave, -1.0, 1.0))