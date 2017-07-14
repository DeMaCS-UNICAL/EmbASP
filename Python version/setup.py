#!/usr/bin/env python

from distutils.core import setup
from setuptools import find_packages

from codecs import open
from os import path

here = path.abspath(path.dirname(__file__))

with open(path.join(here, 'README.rst'), encoding='utf-8') as f:
    long_description = f.read()

setup(name='embASP',
      version='1.0',
      description='embASP',
      long_description=long_description,
      author='Department of Mathematics and Computer Science, University of Calabria',
      license='MIT',
      author_email='embasp@mat.unical.it',
      url='https://www.mat.unical.it/calimeri/projects/embasp/',
      packages=find_packages(exclude=["*.test", "*.test.*", "test.*", "test"]),
      
      classifiers=[
        # How mature is this project? Common values are
        #   3 - Alpha
        #   4 - Beta
        #   5 - Production/Stable
        'Development Status :: 5 - Production/Stable',

        # Pick your license as you wish (should match "license" above)
        'License :: OSI Approved :: MIT License',

        # Specify the Python versions you support here. In particular, ensure
        # that you indicate whether you support Python 2, Python 3 or both.
        'Programming Language :: Python :: 2',
        'Programming Language :: Python :: 3',
        ],
      
     )





