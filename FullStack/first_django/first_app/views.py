from django.http import HttpResponse
from django.shortcuts import render

# Create your views here.
def index(request):
    return render(request, "first_app/index.html")

def sample_view(request, name):
    return render(request, "first_app/sample_view.html", {
        "name": name.capitalize
    })
