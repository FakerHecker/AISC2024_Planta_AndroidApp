package com.example.aisc2024_planta_androidapp.scan

import android.app.Activity
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia
import androidx.camera.core.Camera
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.ClipOp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.example.aisc2024_planta_androidapp.R
import com.example.aisc2024_planta_androidapp.ui.composable.LoadingPopup
import com.example.aisc2024_planta_androidapp.ui.theme.AISC2024_Planta_AndroidAppTheme
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import kotlinx.coroutines.delay

@Preview
@Composable
private fun SSP() {
    AISC2024_Planta_AndroidAppTheme {
        ScanScreen({}, {}, {})
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScanScreen(
    onScanClicked: () -> Unit,
    onDiagnoseClicked: () -> Unit,
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    // make status bar icons white
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
            WindowCompat.getInsetsController(window, view).isAppearanceLightNavigationBars = false
        }
    }

    var selectedMode by remember { mutableIntStateOf(0) }
    var showLoading by remember { mutableStateOf(false) }

    // Photo picker
    // Registers a photo picker activity launcher in single-select mode.
    val pickMedia = rememberLauncherForActivityResult(PickVisualMedia()) { uri ->
        // Callback is invoked after the user selects a media item or closes the
        // photo picker.
        // TODO: Handle the selected media item.
        if (uri != null) {
            Log.d("PhotoPicker", "Selected URI: $uri")
        } else {
            Log.d("PhotoPicker", "No media selected")
        }
    }

    LoadingPopup(label = "Đang quét hình ảnh...", isVisible = showLoading)
    Box(modifier) {
        CameraPreviewScreen(modifier = Modifier.fillMaxSize())
        // The cropped overlay thing
        val topInsets = WindowInsets.statusBars.getTop(LocalDensity.current)
        Canvas(modifier = Modifier.fillMaxSize()) {
            val roundedCorner = 16.dp.toPx()
            val sizeWithMargin = size.minDimension - 32.dp.toPx()
            val marginXOffset = 16.dp.toPx()
            val marginYOffset = topInsets.toFloat() + 154.dp.toPx()
            val roundedCirclePath = Path().apply {
                addRoundRect(RoundRect(Rect(
                    Offset(marginXOffset, marginYOffset),
                    Size(sizeWithMargin, sizeWithMargin)),
                    CornerRadius(roundedCorner, roundedCorner)
                ))
            }
            clipPath(roundedCirclePath, clipOp = ClipOp.Difference) {
                drawRect(SolidColor(Color.Black.copy(alpha = 0.75f)))
            }
        }
        // actual ui
        Scaffold(topBar = { TopAppBar(
            title = { Text("Quét thông minh") },
            navigationIcon = {
                IconButton(onClick = onNavigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors().copy(
                containerColor = Color.Transparent,
                titleContentColor = colorScheme.onPrimary,
                navigationIconContentColor = colorScheme.onPrimary
            )
        )}, containerColor = Color.Transparent) { innerPadding ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxHeight()
                    .padding(horizontal = 16.dp)
            ) {
                Spacer(Modifier.height(40.dp))
                Text(
                    "Để tìm kiếm thông tin chính xác,\nbạn vui lòng chụp rõ nét các chi tiết của cây nhé!",
                    style = typography.labelMedium,
                    textAlign = TextAlign.Center,
                    color = colorScheme.onPrimary,
                )
                // leave out space for the scan cutout
                Spacer(
                    Modifier
                        .padding(top = 20.dp, bottom = 28.dp)
                        .aspectRatio(1f)
                        .fillMaxWidth()
                )
                // steps indicator
                Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    StepIndicator("1", "Chụp ảnh cây trồng")
                    HorizontalDivider(
                        thickness = 1.5.dp, color = colorScheme.onPrimary,
                        modifier = Modifier.weight(1f)
                    )
                    StepIndicator("2", "Phân tích hình ảnh")
                    HorizontalDivider(
                        thickness = 1.5.dp, color = colorScheme.onPrimary,
                        modifier = Modifier.weight(1f)
                    )
                    StepIndicator("3", "Trả về\nkết quả")
                }
                Spacer(Modifier.height(24.dp))

                // Mode toggle
                Row(horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    val options = listOf("Thông tin cây", "Chuẩn đoán bệnh")
                    SingleChoiceSegmentedButtonRow(modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)) {
                        options.forEachIndexed { index, label ->
                            SegmentedButton(
                                icon = { Icon(painter = painterResource(R.drawable.icon_leaf), contentDescription = null) },
                                shape = SegmentedButtonDefaults.itemShape(index = index, count = options.size),
                                onClick = { selectedMode = index },
                                selected = index == selectedMode
                            ) {
                                Text(label, style = typography.labelLarge)
                            }
                        }
                    }
                }

                val executor = ContextCompat.getMainExecutor(LocalContext.current)
                LaunchedEffect(showLoading) {
                    if (!showLoading) return@LaunchedEffect
                    delay(3000)
                    showLoading = false
                    executor.execute {
                        if (selectedMode == 0) {
                            onScanClicked()
                        } else {
                            onDiagnoseClicked()
                        }
                    }
                }

                // Snap button and pick image
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    IconButton(
                        onClick = {
                            showLoading = true
                        },
                        modifier = Modifier.size(64.dp)
                            .align(Alignment.Center)
                    ) {
                        Icon(painter = painterResource(R.drawable.snap),
                            contentDescription = "snap button",
                            tint = colorScheme.onPrimary,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    val context = LocalContext.current
                    IconButton(
                        onClick = {
                            PickVisualMedia.isPhotoPickerAvailable(context)
                            pickMedia.launch(PickVisualMediaRequest(PickVisualMedia.ImageOnly))
                        },
                        modifier = Modifier.size(54.dp)
                            .align(Alignment.CenterStart)
                    ) {
                         Icon(painter = painterResource(R.drawable.photo_library),
                             contentDescription = "pick image from library",
                             tint = colorScheme.onPrimary,
                             modifier = Modifier.fillMaxSize().padding(8.dp)
                         )
                    }
                }
            }
        }
    }
}

@Composable
private fun StepIndicator(stepCount: String, text: String) {
    Column(Modifier.width(66.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            stepCount,
            color = colorScheme.onPrimary,
            textAlign = TextAlign.Center,
            style = typography.labelLarge,
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = colorScheme.onPrimary,
                    shape = RoundedCornerShape(size = 12.dp)
                )
                .size(24.dp)
                .wrapContentHeight(Alignment.CenterVertically)
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text,
            color = colorScheme.onPrimary,
            textAlign = TextAlign.Center,
            style = typography.labelSmall
        )
    }
}

@OptIn(ExperimentalPermissionsApi::class, ExperimentalMaterial3Api::class)
@Composable
fun CameraPreviewScreen(modifier: Modifier = Modifier) {
    // Camera permission state
    val cameraPermissionState = rememberPermissionState(
        android.Manifest.permission.CAMERA
    )

    // TODO: add ask again mechanics

    if (!cameraPermissionState.status.isGranted) {
        val textToShow = if (cameraPermissionState.status.shouldShowRationale) {
            // If the user has denied the permission but the rationale can be shown,
            // then gently explain why the app requires this permission
            "The camera is important for this app. Please grant the permission."
        } else {
            // If it's the first time the user lands on this feature, or the user
            // doesn't want to be asked again for this permission, explain that the
            // permission is required
            "Camera permission required for this feature to be available. " +
                    "Please grant the permission"
        }
        AlertDialog(
            title = { Text("Camera permission required") },
            text = { Text(textToShow) },
            confirmButton = {
                Button(
                    onClick = { cameraPermissionState.launchPermissionRequest() }
                ) {
                    Text("Request permission")
                }
            },
            onDismissRequest = {}
        )
        return
    }

    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    val cameraProviderFuture = remember(context) { ProcessCameraProvider.getInstance(context) }
    val cameraProvider = remember(cameraProviderFuture) { cameraProviderFuture.get() }
    val executor = remember(context) { ContextCompat.getMainExecutor(context) }
    var imageCapture: ImageCapture? by remember { mutableStateOf(null) }
    var cameraSelector: CameraSelector? by remember { mutableStateOf(null) }
    var camera: Camera? by remember { mutableStateOf(null) }
    var preview by remember { mutableStateOf<androidx.camera.core.Preview?>(null) }

    var lensFacing by remember { mutableIntStateOf(CameraSelector.LENS_FACING_BACK) }

    DisposableEffect(Unit) {
        onDispose {
            cameraProvider.unbindAll() // Unbind all use cases before navigating away
        }
    }

    AndroidView(
        factory = { ctx ->
            val previewView = PreviewView(ctx)
            cameraProviderFuture.addListener(
                {
                    cameraSelector = CameraSelector.Builder()
                        .requireLensFacing(lensFacing)
                        .build()
                    imageCapture = ImageCapture.Builder()
                        .setTargetRotation(previewView.display.rotation)
                        .build()

                    cameraProvider.unbindAll()
                    camera = cameraProvider.bindToLifecycle(
                        lifecycleOwner,
                        cameraSelector as CameraSelector,
                        imageCapture,
                        preview
                    )
                }, executor
            )
            preview = androidx.camera.core.Preview.Builder().build().also {
                it.setSurfaceProvider(previewView.surfaceProvider)
            }
            previewView
        },
        modifier = modifier
    )
}