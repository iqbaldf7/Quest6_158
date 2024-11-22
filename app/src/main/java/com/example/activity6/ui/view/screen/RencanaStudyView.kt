import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.activity6.R
import com.example.activity6.data.MataKuliah
import com.example.activity6.data.RuangKelas
import com.example.activity6.model.Mahasiswa
import com.example.praktikum6.ui.widget.DynamicSelectedField

@Composable
fun RencanaStudyView(
    mahasiswa: Mahasiswa,
    onSubmitButtonClicked: (MutableList<String>) -> Unit,
    onBackButtonClicked: () -> Unit
) {
    var chosenDropdown by remember { mutableStateOf("") }
    var checked by remember { mutableStateOf(false) }
    var pilihanKelas by remember { mutableStateOf("") }
    val listData = listOf(chosenDropdown, pilihanKelas)


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.primary))
    ) {
        // Bagian Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.gambarku),
                contentDescription = "",
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .size(50.dp)
            )

            Spacer(modifier = Modifier.padding(start = 16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = mahasiswa.nama,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = Color().White
                )
                Text(
                    text = mahasiswa.nim,
                    fontWeight = FontWeight.Light,
                    fontSize = 12.sp,
                    color = Color.White
                )
            }
            Box() {
                Icon(
                    imageVector = Icons.Filled.Notifications,
                    contentDescription = "",
                    tint = Color.White
                )
            }
        }

        // Bagian Konten
        Box(
            modifier = Modifier
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)
                )
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                // Pilihan Mata Kuliah
                Text(text = "Pilih Mata Kuliah Peminatan", fontWeight = FontWeight.Bold)
                Text(
                    text = "Silahkan pilih mata kuliah yang anda inginkan",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light
                )
                Spacer(modifier = Modifier.padding(8.dp))

                // Dropdown Field
                DynamicSelectedField(
                    selectedValue = chosenDropdown,
                    options = MataKuliah.options,
                    label = "Mata Kuliah",
                    onValueChangedEvent = { chosenDropdown = it }
                )
                Spacer(modifier = Modifier.padding(8.dp))
                HorizontalDivider()
                Spacer(modifier = Modifier.padding(8.dp))

                // Pilihan Kelas
                Text(text = "Pilih Kelas Belajar", fontWeight = FontWeight.Bold)
                Text(
                    text = "Silahkan pilih kelas dari mata kuliah yang anda inginkan",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light
                )
                Spacer(modifier = Modifier.padding(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    RuangKelas.kelas.forEach { kelas ->
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(
                                selected = pilihanKelas == kelas,
                                onClick = { pilihanKelas = kelas }
                            )
                            Text(text = kelas)
                        }
                    }
                }
                Spacer(modifier = Modifier.padding(8.dp))
                HorizontalDivider()
                Spacer(modifier = Modifier.padding(8.dp))

                // Persetujuan
                Text(text = "Klausul Persetujuan Mahasiswa", fontWeight = FontWeight.Bold)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = checked,
                        onCheckedChange = { checked = it },
                        enabled = chosenDropdown.isNotBlank() && pilihanKelas.isNotBlank()
                    )
                    Text(
                        text = "Saya menyetujui setiap pernyataan yang ada tanpa ada paksaan dari pihak manapun.",
                        fontWeight = FontWeight.Light,
                        fontSize = 10.sp
                    )
                }
                Spacer(modifier = Modifier.padding(8.dp))

                // Tombol Navigasi
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(onClick = { onBackButtonClicked() }) {
                        Text(text = "Kembali")
                    }
                    Button(
                        onClick = { onSubmitButtonClicked(listData) },
                        enabled = checked
                    ) {
                        Text(text = "Lanjut")
                    }
                }
            }
        }
    }
}
