package com.javadocmd.libgdx.actor

import com.badlogic.gdx.graphics.Color
import com.javadocmd.cards.ui.UI
import com.javadocmd.libgdx.Size
import com.badlogic.gdx.scenes.scene2d.Touchable

class Guides(size: Size, c: Color) extends PrototypeActor(UI.Resources) {
	
	super.setColor(c)
	setSize(size.w, size.h)
	setPosition(0, 0)
	setTouchable(Touchable.disabled)
	
	private var lines = scala.collection.mutable.Set[SimpleDrawable]()
	override def drawables = lines.toSeq
	
	override def setColor(color: Color) = {
		super.setColor(color)
		lines foreach { _.color(color) }
	}
	
	def addGrid(gridSize: Float) = {
		for (x <- gridSize to size.w by gridSize) { addVerticalLine(x) }
		for (y <- gridSize to size.h by gridSize) { addHorizontalLine(y) }
	}
	
	def addHorizontalLine(y: Float) = { lines.add(CaseHorizontalLine(y).color(getColor())) }
	def addVerticalLine(x: Float) = { lines.add(CaseVerticalLine(x).color(getColor())) }
	
	def removeHorizontalLine(y: Float) = { lines.remove(CaseHorizontalLine(y).color(getColor())) }
	def removeVerticalLine(x: Float) = { lines.remove(CaseVerticalLine(x).color(getColor())) }
	
	def clearLines() = lines.clear()
	
	// Line case classes.
	case class CaseVerticalLine(x: Float) extends this.VerticalLine(x, 1)
	case class CaseHorizontalLine(y: Float) extends this.HorizontalLine(y, 1)
}