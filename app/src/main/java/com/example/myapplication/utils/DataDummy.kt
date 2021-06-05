package com.example.myapplication.utils

import com.example.myapplication.data.source.local.entity.MovieEntity
import com.example.myapplication.data.source.local.entity.TvShowEntity

object DataDummy {

    fun generateDataMovieDummy(): List<MovieEntity> {
        val listMovie = ArrayList<MovieEntity>()

        listMovie.add(
            MovieEntity(
                movieId = 1,
                name = "Mortal Kombat",
                desc = "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                poster = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6Wdl9N6dL0Hi0T1qJLWSz6gMLbd.jpg",
                isFavorite = false
            )
        )

        listMovie.add(
            MovieEntity(
                movieId = 2,
                name = "Godzilla vs. Kong",
                desc = "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet colltvShowIde in a spectacular battle for the ages.",
                poster = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
                isFavorite = false
            )
        )

        listMovie.add(
            MovieEntity(
                movieId = 3,
                name = "劇場版「鬼滅の刃」無限列車編",
                desc = "Tanjiro Kamado, joined with Inosuke Hashibira, a boy raised by boars who wears a boar's head, and Zenitsu Agatsuma, a scared boy who reveals his true power when he sleeps, boards the Infinity Train on a new mission with the Fire Hashira, Kyojuro Rengoku, to defeat a demon who has been tormenting the people and killing the demon slayers who oppose it!",
                poster = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/h8Rb9gBr48ODIwYUttZNYeMWeUU.jpg",
                isFavorite = false
            )
        )

        listMovie.add(
            MovieEntity(
                movieId = 4,
                name = "The Unholy",
                desc =  "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister.",
                poster = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/b4gYVcl8pParX8AjkN90iQrWrWO.jpg",
                isFavorite = false
            )
        )

        listMovie.add(
            MovieEntity(
                movieId = 5,
                name = "Nobody",
                desc =  "Hutch Mansell, a suburban dad, overlooked husband, nothing neighbor — a \"nobody.\" When two thieves break into his home one night, Hutch's unknown long-simmering rage is ignited and propels him on a brutal path that will uncover dark secrets he fought to leave behind.",
                poster = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg",
                isFavorite = false
            )
        )

        listMovie.add(
            MovieEntity(
                movieId = 6,
                name = "Zack Snyder's Justice League",
                desc =  "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
                poster = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg",
                isFavorite = false
            )
        )

        listMovie.add(
            MovieEntity(
                movieId = 7,
                name = "The Marksman",
                desc =  "Jim Hanson’s quiet life is suddenly disturbed by two people crossing the US/Mexico border – a woman and her young son – desperate to flee a Mexican cartel. After a shootout leaves the mother dead, Jim becomes the boy’s reluctant defender. He embraces his role as Miguel’s protector and will stop at nothing to get him to safety, as they go on the run from the relentless assassins.",
                poster = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6vcDalR50RWa309vBH1NLmG2rjQ.jpg",
                isFavorite = false
            )
        )

        listMovie.add(
            MovieEntity(
                movieId = 8,
                name = "Thunder Force",
                desc =  "In a world where supervillains are commonplace, two estranged childhood best friends reunite after one devises a treatment that gives them powers to protect their city.",
                poster = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/duK11VQd4UPDa7UJrgrGx90xJOx.jpg",
                isFavorite = true
            )
        )

        listMovie.add(
            MovieEntity(
                movieId = 9,
                name = "Chaos Walking",
                desc =  "Two unlikely companions embark on a perilous adventure through the badlands of an unexplored planet as they try to escape a dangerous and disorienting reality, where all inner thoughts are seen and heard by everyone.",
                poster = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/9kg73Mg8WJKlB9Y2SAJzeDKAnuB.jpg",
                isFavorite = true
            )
        )

        listMovie.add(
            MovieEntity(
                movieId = 10,
                name = "Vanquish",
                desc =  "Victoria is a young mother trying to put her dark past as a Russian drug courier behind her, but retired cop Damon forces Victoria to do his btvShowIdding by holding her daughter hostage. Now, Victoria must use guns, guts and a motorcycle to take out a series of violent gangsters—or she may never see her child again.",
                poster = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/AoWY1gkcNzabh229Icboa1Ff0BM.jpg",
                isFavorite = true
            )
        )

        return listMovie
    }

    fun generateDataTvShowDummy(): List<TvShowEntity> {
        val listTvShow = ArrayList<TvShowEntity>()

        listTvShow.add(
            TvShowEntity(
                tvShowId = 1,
                name = "The Falcon and the Winter Soldier",
                desc =  "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                poster = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                isFavorite = false
            )
        )

        listTvShow.add(
            TvShowEntity(
                tvShowId = 2,
                name = "The Office",
                desc =  "The everyday lives of office employees in the Scranton, Pennsylvania branch of the fictional Dunder Mifflin Paper Company.",
                poster = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/qWnJzyZhyy74gjpSjIXWmuk0ifX.jpg",
                isFavorite = false
            )
        )

        listTvShow.add(
            TvShowEntity(
                tvShowId = 3,
                name = "The Good Doctor",
                desc =  "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                poster = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                isFavorite = false
            )
        )

        listTvShow.add(
            TvShowEntity(
                tvShowId = 4,
                name = "The Flash",
                desc =  "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                poster = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                isFavorite = false
            )
        )

        listTvShow.add(
            TvShowEntity(
                tvShowId = 5,
                name = "Luis Miguel: La Serie",
                desc =  "The series dramatizes the life story of Mexican superstar singer Luis Miguel, who has captivated audiences in Latin America and beyond for decades.",
                poster = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/34FaY8qpjBAVysSfrJ1l7nrAQaD.jpg",
                isFavorite = false
            )
        )

        listTvShow.add(
            TvShowEntity(
                tvShowId = 6,
                name = "Grey's Anatomy",
                desc =  "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                poster = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/jnsvc7gCKocXnrTXF6p03cICTWb.jpg",
                isFavorite = false
            )
        )

        listTvShow.add(
            TvShowEntity(
                tvShowId = 7,
                name = "Invincible",
                desc =  "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his father’s tutelage.",
                poster = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg",
                isFavorite = false
            )
        )

        listTvShow.add(
            TvShowEntity(
                tvShowId = 8,
                name = "Riverdale",
                desc =  "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                poster = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
                isFavorite = true
            )
        )

        listTvShow.add(
            TvShowEntity(
                tvShowId = 9,
                name = "Van Helsing",
                desc =  "Vanessa Helsing, the daughter of famous vampire hunter and Dracula nemesis Abraham Van Helsing is resurrected five years in the future to find out that vampires have taken over the world and that she possesses unique power over them. She is humanity’s last hope to lead an offensive to take back what has been lost.",
                poster = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/r8ODGmfNbZQlNhiJl2xQENE2jsk.jpg",
                isFavorite = true
            )
        )

        listTvShow.add(
            TvShowEntity(
                tvShowId = 10,
                name = "Lucifer",
                desc =  "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                poster = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                isFavorite = true
            )
        )

        return listTvShow
    }

    fun generateDummyMovieFavorite(): List<MovieEntity>{
        val dummyMovies = generateDataMovieDummy()
        val favoriteMovies = ArrayList<MovieEntity>()

        for (movie in dummyMovies){
            if (movie.isFavorite){
                favoriteMovies.add(movie)
            }
        }

        return favoriteMovies

    }

    fun generateDummyTvShowFavorite(): List<TvShowEntity>{
        val dummyTvShow = generateDataTvShowDummy()
        val favoriteTvShows = ArrayList<TvShowEntity>()

        for (tvShow in dummyTvShow){
            if (tvShow.isFavorite){
                favoriteTvShows.add(tvShow)
            }
        }

        return favoriteTvShows

    }
}