import setuptools

with open("README.md", "r") as fh:
    long_description = fh.read()

setuptools.setup(
    name="RestaurAID",
    version="1.0",
    author="Femio23",
    author_email="chiscazo.paco@gmail.com",
    description="Empaquetado do proxecto.",
    url="https://github.com/masterfabela/Estudios/tree/master/FRMCode/DI/ProxectoRestaurante",
    packages=setuptools.find_packages(),
    classifiers=[
        "Programming Language :: Python :: 3",
        "License :: OSI Approved :: MIT License",
        "Operating System :: OS Independent",
    ],
)