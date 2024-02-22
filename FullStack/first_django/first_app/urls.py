from django.urls import path
from . import views

urlpatterns = [
    path("", views.index, name="index"),
    path("sample_page", views.sample_view, name="sample_view"),
    path("<str:name>", views.sample_view, name="Sample View"),
]