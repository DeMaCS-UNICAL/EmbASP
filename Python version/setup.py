#!/usr/bin/env python

from distutils.core import setup
from setuptools import find_packages

from codecs import open
from os import path

# here = path.abspath(path.dirname(__file__))
#
# with open(path.join(here, 'README.rst'), encoding='utf-8') as f:
#     long_description = f.read()

setup(name='EmbASP',
      version='1.1',
      description='EmbASP',
      # long_description=long_description,
      author='Department of Mathematics and Computer Science, University of Calabria',
      license='MIT',
      author_email='embasp@mat.unical.it',
      url='https://www.mat.unical.it/calimeri/projects/embasp/',
      packages=find_packages(exclude=["*.test", "*.test.*", "test.*", "test"]),

      classifiers=[
          'Development Status :: 5 - Production/Stable',

          'License :: OSI Approved :: MIT License',

          'Programming Language :: Python :: 2',
          'Programming Language :: Python :: 3',
      ],

      )
