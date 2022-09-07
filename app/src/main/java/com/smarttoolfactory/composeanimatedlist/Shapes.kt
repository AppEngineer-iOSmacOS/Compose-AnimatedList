package com.smarttoolfactory.composeanimatedlist

import androidx.compose.foundation.shape.GenericShape
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.LayoutDirection

/**
 * Aspect ratio list with pre-defined aspect ratios
 */
val aspectRatios = listOf(
    ShapeModel("9:16", createRectShape(9 / 16f)),
    ShapeModel("2:3", createRectShape(2 / 3f)),
    ShapeModel("1:1", createRectShape(1 / 1f)),
    ShapeModel("16:9", createRectShape(16 / 9f)),
    ShapeModel("1.91:1", createRectShape(1.91f / 1f)),
    ShapeModel("3:2", createRectShape(3 / 2f)),
    ShapeModel("3:4", createRectShape(3 / 4f)),
    ShapeModel("3:5", createRectShape(3 / 5f)),
)

/**
 * Creates a [Rect] shape with given aspect ratio.
 */
fun createRectShape(aspectRatio: Float): GenericShape {
    return GenericShape { size: Size, _: LayoutDirection ->

        val width = size.width
        val height = size.height
        val shapeSize = if (aspectRatio > 1) Size(width = width, height = width / aspectRatio)
        else Size(width = height * aspectRatio, height = height)

        addRect(Rect(offset = Offset.Zero, size = shapeSize))
    }
}