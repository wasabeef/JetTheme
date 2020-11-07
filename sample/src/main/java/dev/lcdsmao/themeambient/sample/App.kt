package dev.lcdsmao.themeambient.sample

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.lcdsmao.themeambient.AppThemeAmbient
import dev.lcdsmao.themeambient.ProvideAppTheme
import dev.lcdsmao.themeambient.buildMaterialThemeDataMap

@Composable
fun App() {
  ProvideAppTheme(
    themeDataMap = themes,
    animSpec = remember { spring(stiffness = Spring.StiffnessLow) }
  ) {
    Scaffold(
      floatingActionButton = {
        val manager = AppThemeAmbient.current
        FloatingActionButton(
          backgroundColor = MaterialTheme.colors.primary,
          onClick = {
            manager.setTheme(if (manager.theme?.themeId == "default") "dark" else "default")
          }
        ) {
          Icon(asset = Icons.Default.Refresh)
        }
      }
    ) {
      Column(
        modifier = Modifier.fillMaxWidth().padding(32.dp)
      ) {
        Text(text = "Heading 1", style = MaterialTheme.typography.h1, maxLines = 1)
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = "Heading 2", style = MaterialTheme.typography.h2, maxLines = 1)
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = "Heading 3", style = MaterialTheme.typography.h3, maxLines = 1)
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = "Heading 4", style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = "Heading 5", style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = "Heading 6", style = MaterialTheme.typography.h6)

        Spacer(modifier = Modifier.size(32.dp))

        Row {
          Box(modifier = Modifier.size(64.dp).background(MaterialTheme.colors.primary))
          Spacer(modifier = Modifier.size(16.dp))
          Box(modifier = Modifier.size(64.dp).background(MaterialTheme.colors.primaryVariant))
          Spacer(modifier = Modifier.size(16.dp))
          Box(modifier = Modifier.size(64.dp).background(MaterialTheme.colors.secondary))
        }
      }
    }
  }
}

private val shapes = Shapes(
  small = RoundedCornerShape(4.dp),
  medium = RoundedCornerShape(4.dp),
  large = RoundedCornerShape(0.dp)
)

private val typography = Typography()

private val darkColorPalette = darkColors(
  primary = Color(0xFFBB86FC),
  primaryVariant = Color(0xFF3700B3),
  secondary = Color(0xFF03DAC5),
)

private val lightColorPalette = lightColors(
  primary = Color(0xFFFEDBD0),
  primaryVariant = Color(0xFFFFF0E8),
  secondary = Color(0xFFCC4C33),
  onPrimary = Color(0xFF442C2E),
)

private val themes = buildMaterialThemeDataMap {
  defaultTheme(
    colors = lightColorPalette,
    typography = typography,
    shapes = shapes,
  )
  theme(
    themeId = "dark",
    colors = darkColorPalette,
  )
}