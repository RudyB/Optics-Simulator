### [Table of Contents](#table-of-contents)

I. [Physics Concepts](#physics-concepts)
* [Circular Hole Diffraction](#circular-hole-diffraction)
* [Diffraction Grating](#diffraction-grating)  

II. [Screenshots of Simulation GUI](#simulation-gui)  
III. [License](#license)

# Physics Concepts

### Circular Hole Diffraction: 

For a circular aperture, interference occurs between all rays from the whole area producing a series of concentric fringes. The exact solution in this case is difficult but turns out to be of the same form as for a slit (d ∙ sinθ = 𝑚 λ) except that m is non-integer (i.e. m = 1.22, 2.23, 3.24, 4.24, 5.24. . .) and d is the diameter of the hole. The interference fringes produced by diffraction of laser light by a circular aperture is showed below:

![Figure 9](https://i.imgur.com/lGHajnQ.png)

> Optical setup and diffraction pattern of a circular-aperture

The intensity pattern for a circular hole diffraction, known as the Airy pattern, looks like: 
   
![Airy Pattern Formula](https://i.imgur.com/CKeNmZ4.png)

where β = 𝜋𝐷sinθ /λ and J1 is a Bessel function of the first kind of order unity, whose value are tabulated as follows:

![](https://i.imgur.com/GiOCXMC.png)

![](https://i.imgur.com/bjKi5qp.png)
> Comparison between the intensity profiles of single-slit aperture and circular aperture

**Combine interference (2-slit) with diffraction (finite-width slit):** When the aperture consists of two finite slits, each of width D, separated by a distance d, then the intensity pattern is a combination of both the single-slit pattern and the double slit pattern: the amplitude of the two slit interference pattern is modulated by a single slit diffraction pattern, as shown below.

![](https://i.imgur.com/Mp7ABzJ.png)

The intensity diffraction pattern for a double-slit looks like:

![](https://i.imgur.com/ldXmJHV.png)
> Central-line intensity profile on a double-slit diffraction experiment

In this full pattern, the finely spaced interference maxima (from the double-slit) are spaced Δθ = λ/d apart, while the more widely spaced minima of the single-slit diffraction pattern are separated by Δθ = λ/D (except for the first 2 minima whose separation is 2λ/D)

### Diffraction Grating: 
The diffraction grating is an optical component used to spatially separate polychromatic light (white light) into its constituent optical frequencies. Diffraction gratings are used in such diverse fields as spectroscopy, colorimetry, metrology and laser optics.

A large number of parallel, closely spaced slits constitutes a diffraction grating, characterized by the spacing d. G = 1/d is the slit frequency or slit density, more commonly called "lines per millimeter".

The condition for maximum intensity is known as the grating equation, same as [1]: 

d∙sinθ=𝑚λ, 𝑚=1,2,3...

![Diffraction Grating](https://i.imgur.com/vsDknvb.png)
However, angular separation of the maxima is generally much greater because the slit spacing is so small for a diffraction grating. The intensity maximum is very sharp and narrow, providing the high resolution for spectroscopic applications. The peak intensities are also much higher for the grating than for the double slit

# Simulation GUI

![Circular Hole Diffraction](https://i.imgur.com/OCzlxpx.png)
![Grating Diffraction](https://i.imgur.com/Aq4iZoG.png)

# License

This repository is released under the MIT license. See [LICENSE](/LICENSE) for details.
