import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.speedotransfer.R
import com.example.speedotransfer.ui.elements.BeneficiaryCard
import com.example.speedotransfer.ui.elements.SpeedoButton
import com.example.speedotransfer.ui.elements.StepsRow
import com.example.speedotransfer.ui.screens.tansfer.TransferConfirmationDesign
import com.example.speedotransfer.ui.theme.BodyMedium16
import com.example.speedotransfer.ui.theme.BodyRegular16
import com.example.speedotransfer.ui.theme.G900
import com.example.speedotransfer.ui.theme.TitleSemiBold

@Composable
fun TransferConfirmedDesign(
    senderName: String,
    receiverName: String,
    senderAccountNumberSuffix: String,
    receiverAccountNumberSuffix: String,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .padding(start = 16.dp, end = 16.dp, top = 24.dp)
            .verticalScroll(scrollState)
    ) {

        StepsRow(currentStep = 3)
        TransferDoneSuccesfullyArea()
        AccountsDetailsArea(
            senderName = senderName,
            receiverName = receiverName,
            senderAccountNumberSuffix = senderAccountNumberSuffix,
            receiverAccountNumberSuffix =receiverAccountNumberSuffix
        )

        SpeedoButton(text = "Back to Home", enabled = true, isTransparent = false)
        Spacer(modifier = Modifier.padding(bottom = 16.dp))
        SpeedoButton(text = "Add to Favourite", enabled = false, isTransparent = true)
        Spacer(modifier = Modifier.padding(bottom = 16.dp))
    }


}


@Composable
fun AccountsDetailsArea(
    senderName: String,
    receiverName: String,
    senderAccountNumberSuffix: String,
    receiverAccountNumberSuffix: String,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.padding(bottom = 32.dp)) {
        Column {
            BeneficiaryCard(
                direction = R.string.from,
                clientName = senderName,
                accountNumberSuffix = senderAccountNumberSuffix
            )
            Spacer(modifier = Modifier.padding(bottom = 12.dp))
            BeneficiaryCard(
                direction = R.string.to,
                clientName = receiverName,
                accountNumberSuffix = receiverAccountNumberSuffix
            )
        }
        Image(
            painter = painterResource(id = R.drawable.right_arrow_transactions),
            contentDescription = "transfer arrows",
            modifier = Modifier
                .size(44.dp)
                .align(Alignment.Center)
        )
    }

}


@Composable
fun TransferDoneSuccesfullyArea(
    modifier: Modifier = Modifier
) {

    Column(
        Modifier
            .padding(top = 24.dp, bottom = 16.dp)
            .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
       Image(painter = painterResource(id = R.drawable.two_d_right_sign) , contentDescription = "Right mark",Modifier.size(86.dp))
        Text(
            text = "Your transfer was successful",
            style = TitleSemiBold, fontSize = 20.sp,
            color = G900, modifier = modifier.padding(top = 16.dp)
        )

    }
}

@Preview(showSystemUi = true)
@Composable
private fun TransferConfirmedPreview() {
    TransferConfirmedDesign(
        senderName = "Asmaa Dosuky",
        receiverName = "Jonathon Smith",
        senderAccountNumberSuffix = "7890",
        receiverAccountNumberSuffix = "7890"
    )

}