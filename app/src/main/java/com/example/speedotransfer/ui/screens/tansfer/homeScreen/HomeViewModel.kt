import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.speedotransfer.data.repository.transfer.TransferRepo
import com.example.speedotransfer.model.TransactionResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val transferRepo: TransferRepo) : ViewModel() {


    private val _transactionHistory = MutableStateFlow<List<TransactionResponse>>(emptyList())
    val transactionHistory: StateFlow<List<TransactionResponse>> = _transactionHistory

    private val _transactionDetails = MutableStateFlow<TransactionResponse?>(null)
    val transactionDetails: StateFlow<TransactionResponse?> = _transactionDetails


    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    fun fetchTransactionHistory(accountId: Long, startDate: String, endDate: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null
            try {
                val history = transferRepo.getTransactionHistory()
                _transactionHistory.value = history
            } catch (e: Exception) {
                _errorMessage.value = "Error fetching transaction history: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }


    fun getTransactionById(transactionId: Long) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null
            try {
                val transaction = transferRepo.getTransactionById(transactionId)
                _transactionDetails.value = transaction
            } catch (e: Exception) {
                _errorMessage.value = "Error fetching transaction details: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}
