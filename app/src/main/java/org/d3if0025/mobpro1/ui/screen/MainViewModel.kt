import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import org.d3if0025.mobpro1.database.CuciDao
import org.d3if0025.mobpro1.model.Cuci

class MainViewModel(sepatuDao: CuciDao) : ViewModel() {
    val data: StateFlow<List<Cuci>> = sepatuDao.getTopup().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = emptyList()
    )
}
