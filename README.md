### Table of Contents

I. Physics Concepts
* Circular Hole Diffraction
* Diffraction Grating  

II. Screenshots of Simulation GUI  
III. License

# Physics Concepts

### Circular Hole Diffraction: 

For a circular aperture, interference occurs between all rays from the whole area producing a series of concentric fringes. The exact solution in this case is difficult but turns out to be of the same form as for a slit (d ∙ sinθ = 𝑚 λ) except that m is non-integer (i.e. m = 1.22, 2.23, 3.24, 4.24, 5.24. . .) and d is the diameter of the hole. The interference fringes produced by diffraction of laser light by a circular aperture is showed below:

![Figure 9](https://www.dropbox.com/s/y8mo7sngpet895c/Screenshot%202017-02-06%2019.41.26.png?dl=1)

> Optical setup and diffraction pattern of a circular-aperture

The intensity pattern for a circular hole diffraction, known as the Airy pattern, looks like: 
   
![Airy Pattern Formula](https://www.dropbox.com/s/7qe66upol0s3gvh/Screenshot%202017-02-06%2019.43.32.png?dl=1)

where β = 𝜋𝐷sinθ /λ and J1 is a Bessel function of the first kind of order unity, whose value are tabulated as follows:

![](https://www.dropbox.com/s/9oquwedqna7o7ts/Screenshot%202017-02-06%2019.44.39.png?dl=1)

![](https://www.dropbox.com/s/zoxl5lvb989kcld/Screenshot%202017-02-06%2019.52.55.png?dl=1)
> Comparison between the intensity profiles of single-slit aperture and circular aperture

**Combine interference (2-slit) with diffraction (finite-width slit):** When the aperture consists of two finite slits, each of width D, separated by a distance d, then the intensity pattern is a combination of both the single-slit pattern and the double slit pattern: the amplitude of the two slit interference pattern is modulated by a single slit diffraction pattern, as shown below.

![](https://www.dropbox.com/s/cpqo7zfammbiy9d/Screenshot%202017-02-06%2019.54.39.png?dl=1)

The intensity diffraction pattern for a double-slit looks like:

![](https://www.dropbox.com/s/2jct1v2l6zivqcn/Screenshot%202017-02-06%2019.55.56.png?dl=1)
> Central-line intensity profile on a double-slit diffraction experiment

In this full pattern, the finely spaced interference maxima (from the double-slit) are spaced Δθ = λ/d apart, while the more widely spaced minima of the single-slit diffraction pattern are separated by Δθ = λ/D (except for the first 2 minima whose separation is 2λ/D)

### Diffraction Grating: 
The diffraction grating is an optical component used to spatially separate polychromatic light (white light) into its constituent optical frequencies. Diffraction gratings are used in such diverse fields as spectroscopy, colorimetry, metrology and laser optics.

A large number of parallel, closely spaced slits constitutes a diffraction grating, characterized by the spacing d. G = 1/d is the slit frequency or slit density, more commonly called "lines per millimeter".

The condition for maximum intensity is known as the grating equation, same as [1]: 

d∙sinθ=𝑚λ, 𝑚=1,2,3...

![Diffraction Grating](https://www.dropbox.com/s/k7ufglnlj4b57qd/Screenshot%202017-02-06%2019.47.15.png?dl=1)
However, angular separation of the maxima is generally much greater because the slit spacing is so small for a diffraction grating. The intensity maximum is very sharp and narrow, providing the high resolution for spectroscopic applications. The peak intensities are also much higher for the grating than for the double slit

# Simulation GUI

![Circular Hole Diffraction](https://www.dropbox.com/s/vjgq0ik0949m0hq/Screenshot%202017-02-06%2020.04.39.png?dl=1)
![Grating Diffraction](https://www.dropbox.com/s/pirwo0a42qb43pi/Screenshot%202017-02-06%2020.05.27.png?dl=1)

# License

This repository is released under the MIT license. See LICENSE for details.
