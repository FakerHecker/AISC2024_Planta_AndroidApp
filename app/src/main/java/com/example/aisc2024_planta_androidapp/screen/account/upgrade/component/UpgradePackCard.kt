package com.example.aisc2024_planta_androidapp.screen.account.upgrade.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.datasource.CollectionPreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.example.aisc2024_planta_androidapp.R
import com.example.aisc2024_planta_androidapp.component.IconContainer
import com.example.aisc2024_planta_androidapp.screen.account.upgrade.component.UpgradePackType.*
import com.example.aisc2024_planta_androidapp.ui.theme.AISC2024_Planta_AndroidAppTheme
import com.example.aisc2024_planta_androidapp.ui.theme.primaryGradient
import com.example.aisc2024_planta_androidapp.util.addGradient

enum class UpgradePackType {
    Econ, Member, Premium, Free
}

@Composable
fun UpgradePackCard(
    packType: UpgradePackType,
    isCurrentPack: Boolean,
    modifier: Modifier = Modifier
) {
    // can move into the enum class or refactor into data class, but 2 days eh
    val icon = when (packType) {
        Econ -> R.drawable.icon_filter_vintage
        Member -> R.drawable.icon_stars
        Premium -> R.drawable.icon_leaf_filled
        Free -> R.drawable.icon_hexagon
    }
    val title = when (packType) {
        Econ -> "Tiết kiệm"
        Member -> "Hội viên"
        Premium -> "Hội viên cao cấp"
        Free -> "Miễn phí"
    }
    val isRecommended = packType == Member
    val price = when (packType) {
        Econ -> "19.000₫"
        Member -> "79.000₫"
        Premium -> "149.000₫"
        Free -> ""
    }
    val features = when (packType) {
        Econ -> listOf(
            "Bao gồm các chức năng của gói Miễn phí",
            "Trải nghiệm không quảng cáo",
            "Đề xuất phân bón, chăm sóc và trị bệnh cho cây"
        )
        Member -> listOf(
            "Bao gồm các chức năng của gói Tiết kiệm",
            "Tối đa 20 cây trong vườn",
            "Scan thông tin và bệnh cho cây",
            "Tích lá đổi quà (giới hạn số điểm trong 1 tháng)",
            "Gợi ý cây trồng theo thời tiết"
        )
        Premium -> listOf(
            "Bao gồm các chức năng của gói Hội viên",
            "Không giới hạn cây trong vườn",
            "Không giới hạn tích lá đổi quà",
            "Xuất báo cáo, lịch chăm sóc cây"
        )
        Free -> listOf(
            "Tối đa 10 cây trong vườn",
            "Quảng cáo trong ứng dụng",
            "Tìm kiếm cây trồng, bệnh trên cây",
            "Xem thời tiết và tin tức về cây",
            "Xem cách phòng trị bệnh cho cây"
        )
    }
    OutlinedCard(modifier) {
        Box {
            if (packType != Free && !isSystemInDarkTheme()) {
                val bgImage = when (packType) {
                    Econ -> R.drawable.member_card_bg_1
                    Member -> R.drawable.member_card_bg_2
                    Premium -> R.drawable.member_card_bg_3
                    else -> throw NotImplementedError("How did you get here")
                }
                Image(
                    painterResource(bgImage),
                    null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .matchParentSize()
                        .alpha(0.6f)
                )
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.padding(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    val iconModifier =
                        if (packType == Free) Modifier
                        else Modifier.addGradient(colorScheme.primaryGradient)
                    IconContainer {
                        Icon(
                            painterResource(icon), null,
                            iconModifier
                        )
                    }
                    val titleStyle =
                        if (packType == Free) typography.titleLarge
                        else typography.titleLarge.copy(
                            brush = colorScheme.primaryGradient
                        )
                    Text(title, style = titleStyle, modifier = Modifier.weight(1f))
                    if (isRecommended) RecommendedChip()
                    else if (packType == Free) DefaultPackChip()
                }

                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    features.forEach {
                        Text("   •   $it", style = typography.labelSmall)
                    }
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(Modifier.weight(1f)) {
                        if (packType != Free) {
                            Text(price, style = typography.headlineSmall,
                                modifier = Modifier.alignByBaseline()
                            )
                            Spacer(Modifier.width(4.dp))
                            Text("/tháng", style = typography.bodyMedium,
                                modifier = Modifier.alignByBaseline()
                            )
                        }
                    }
                    OutlinedButton(onClick = {} /* TODO */,
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = colorScheme.surfaceContainer
                        ),
                        enabled = !isCurrentPack
                    ) {
                        val text = if (isCurrentPack) "Đang dùng"
                        else "Nâng cấp"
                        Text(text)
                    }
                }
            }
        }
    }
}

private class TypeProvider : CollectionPreviewParameterProvider<UpgradePackType>(listOf(
    Econ,
    Member,
    Premium,
    Free
))

@Preview
@Composable
private fun Prev(@PreviewParameter(TypeProvider::class) type: UpgradePackType) {
    val isCurrentPack = type == Free
    AISC2024_Planta_AndroidAppTheme {
        UpgradePackCard(type, isCurrentPack, Modifier.padding(16.dp))
    }
}

@Composable
private fun RecommendedChip(modifier: Modifier = Modifier) {
    Box(
        Modifier
            .border(1.dp, colorScheme.outline, RoundedCornerShape(percent = 100))
            .background(colorScheme.surfaceContainerHighest)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Icon(
                painterResource(R.drawable.icon_check_circle), null,
                tint = colorScheme.primary
            )
            Spacer(Modifier.width(4.dp))
            Text("Khuyên dùng",
                style = typography.labelSmall,
                color = colorScheme.primary
            )
        }
    }
}

@Composable
fun DefaultPackChip(modifier: Modifier = Modifier) {
    Box(Modifier.border(
        1.dp, colorScheme.outline,
        RoundedCornerShape(percent = 100)
    )) {
        Text("Gói mặc định",
            style = typography.labelSmall,
            modifier = Modifier.padding(vertical = 6.dp, horizontal = 10.dp)
        )
    }
}