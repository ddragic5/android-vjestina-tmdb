package endava.codebase.android.movieapp

import android.app.Application
import endava.codebase.android.movieapp.data.dataModule
import endava.codebase.android.movieapp.data.favoritesModule
import endava.codebase.android.movieapp.data.homeModule
import endava.codebase.android.movieapp.data.movieDetailsModule
import org.koin.core.context.GlobalContext.startKoin

class MovieApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                dataModule,
                favoritesModule,
                movieDetailsModule,
                homeModule
            )
        }
    }
}
