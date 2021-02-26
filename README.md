# Movie Restfull API

*Spring Data JPA

*Spring Data REST

*springboot Security

*mysql 



1- clone this project using git console (git clone #link...)

2 update the project with maven->update project

3 import the database using your preference tool, could be xammp or MySQL Workbench (path:main/resource/moviesdb)

* admin auth: user:antonio  pass: papa

* user auth : user: user    pass: goodness


# Requirements

Only users with admin role are allowed to perform the following actions:

* Add a movie
* Modify a movie
* Remove a movie
* Delete a movie
* Movies must have a title, description, at least one image, stock, rental price, sale price and availability.
* Availability is a field of movies, which may only be modified by an admin role.
* Save a log of the title, rental price and sale price updates for a movie.
* Users can rent and buy a movie. For renting functionality you must keep track when the user have to return the movie and apply a monetary *   penalty if there is a delay.
* Keep a log of all rentals and purchases (who bought, how many, when).
* Users can like movies.
* As an admin I’m able to see all movies and filtering by availability/unavailability.
* As an user I’m able to see only the available movies for renting or buying.
* The list must be sortable by title (default), and by popularity (likes).
* The list must have pagination functionality.
* Search through the movies by name.
* 
# Security requirements

* Add login/logout functionality.Preferably JWT.
* Only admins can add/modify/remove movies.
* Only logged in users can rent and buy movies.
* Only logged in users can like movies.
* Everyone (authenticated or not) can get the list of movies.
* Everyone (authenticated or not) can get the detail of a movie


