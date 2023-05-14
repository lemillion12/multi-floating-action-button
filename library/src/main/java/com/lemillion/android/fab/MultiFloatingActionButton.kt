package com.lemillion.android.fab

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun MultiFloatingActionButton(
    fabIcon: ImageVector,
    items: List<FabItem>,
    showLabels: Boolean = true,
    contentColor: Color,
    containerColor: Color
) {
    var currentState by remember { mutableStateOf(MultiFabState.COLLAPSED) }
    val stateTransition: Transition<MultiFabState> =
        updateTransition(targetState = currentState, label = "")
    // State Change
    val stateChange: () -> Unit = {
        currentState = if (stateTransition.currentState == MultiFabState.EXPANDED) {
            MultiFabState.COLLAPSED
        } else MultiFabState.EXPANDED
    }
    // Fab Rotation Animation
    val rotation: Float by stateTransition.animateFloat(
        transitionSpec = {
            if (targetState == MultiFabState.EXPANDED) {
                spring(stiffness = Spring.StiffnessLow)
            } else {
                spring(stiffness = Spring.StiffnessMedium)
            }
        },
        label = ""
    ) { state ->
        if (state == MultiFabState.EXPANDED) 45f else 0f
    }

    Column(
        horizontalAlignment = Alignment.End,
    ) {
        items.forEach { item ->
            SmallFloatingActionButtonRow(
                item = item,
                stateTransition = stateTransition,
                showLabel = showLabels,
                contentColor = contentColor,
                containerColor = containerColor,
            )
            Spacer(modifier = Modifier.height(20.dp))
        }
        FloatingActionButton(
            contentColor = contentColor,
            containerColor = containerColor,
            onClick = stateChange
        ) {
            Icon(
                imageVector = fabIcon,
                contentDescription = "",
                modifier = Modifier.rotate(rotation)
            )
        }
    }
}