package endava.codebase.android.movieapp.mock

import endava.codebase.android.movieapp.model.Actor
import endava.codebase.android.movieapp.model.Crewman
import endava.codebase.android.movieapp.model.Movie
import endava.codebase.android.movieapp.model.MovieDetails

object MoviesMock {

    fun getMoviesList(): List<Movie> = listOf(
        Movie(
            id = 1,
            title = "Venom: Let There Be Carnage",
            overview = "After finding a host body in investigative reporter Eddie Brock, the alien symbiote must face a new enemy, Carnage, the alter ego of serial killer Cletus Kasady.",
            imageUrl = "https://image.tmdb.org/t/p/w500/rjkmN1dniUHVYAtwuV3Tji7FsDO.jpg",
            isFavorite = false,
        ),
        Movie(
            id = 2,
            title = "Iron Man",
            overview = "After being held captive in an Afghan cave, billionaire engineer Tony Stark creates a unique weaponized suit of armor to fight evil.",
            imageUrl = "https://image.tmdb.org/t/p/w500/78lPtwv72eTNqFW9COBYI0dWDJa.jpg",
            isFavorite = true,
        ),
        Movie(
            id = 3,
            title = "Interstellar",
            overview = "The adventures of a group of explorers who make use of a newly discovered wormhole to surpass the limitations on human space travel and conquer the vast distances involved in an interstellar voyage.",
            imageUrl = "https://image.tmdb.org/t/p/w500/gEU2QniE6E77NI6lCU6MxlNBvIx.jpg",
            isFavorite = false,
        ),
        Movie(
            id = 4,
            title = "Inception",
            overview = "Cobb, a skilled thief who commits corporate espionage by infiltrating the subconscious of his targets is offered a chance to regain his old life as payment for a task considered to be impossible: \"inception\", the implantation of another person's idea into a target's subconscious.",
            imageUrl = "https://image.tmdb.org/t/p/w500/edv5CZvWj09upOsy2Y6IwDhK8bt.jpg",
            isFavorite = true,
        ),
        Movie(
            id = 5,
            title = "Ant Man",
            overview = "Scott Lang i Hope Van Dyne, zajedno s Hopeinim roditeljima Hankom Pymom i Janet Van Dyne, te njegovom kćeri Cassie Lang, istražuju Kvantno carstvo u kojem komuniciraju s neobičnim stvorenjima i upuštaju se u avanturu koja nadilazi granice onoga što su mislili da je moguće.",
            imageUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/slLNg0gmy4PtVR3saE44iEshNJU.jpg",
            isFavorite = false,
        ),
    )

    fun getMovieDetails(): MovieDetails = MovieDetails(
        movie = Movie(
            id = 5,
            title = "Spider-Man: No Way Home",
            overview = "Scott Lang i Hope Van Dyne, zajedno s Hopeinim roditeljima Hankom Pymom i Janet Van Dyne, te njegovom kćeri Cassie Lang, istražuju Kvantno carstvo u kojem komuniciraju s neobičnim stvorenjima i upuštaju se u avanturu koja nadilazi granice onoga što su mislili da je moguće.",
            imageUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/slLNg0gmy4PtVR3saE44iEshNJU.jpg",
            isFavorite = false,
        ),
        voteAverage = 0.65f,
        releaseDate = "02/17/2023",
        language = "US",
        runtime = 125,
        crew = List(6) {
            Crewman(
                id = it,
                name = "Peyton Reed",
                job = "Director",
            )
        },
        cast = List(6) {
            Actor(
                id = it,
                name = "Paul Rudd",
                character = "Scott Lang / Ant Man",
                imageUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/slLNg0gmy4PtVR3saE44iEshNJU.jpg"
            )
        },
    )

    fun getCrewman(): Crewman = Crewman(
        id = 1,
        name = "Jon Favreau",
        job = "Director"
    )

    fun getActor(): Actor = Actor(
        id = 1,
        name = "Robert Downey Jr.",
        character = "Tony Stark/Iron Man",
        imageUrl = "https://www.themoviedb.org/t/p/w200/5qHNjhtjMD4YWH3UP0rm4tKwxCL.jpg"
    )

    fun getMovieDetails(movieId: Int): MovieDetails = MovieDetails(
        movie = getMoviesList().first { it.id == movieId },
        voteAverage = 0.65f,
        releaseDate = "02/17/2023",
        language = "US",
        runtime = 125,
        crew = List(6) {
            Crewman(
                id = it,
                name = "Peyton Reed",
                job = "Director",
            )
        },
        cast = List(6) {
            Actor(
                id = it,
                name = "Paul Rudd",
                character = "Scott Lang / Ant-Man",
                imageUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/slLNg0gmy4PtVR3saE44iEshNJU.jpg"
            )
        }
    )
}
