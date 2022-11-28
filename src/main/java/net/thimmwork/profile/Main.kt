package net.thimmwork.profile

import com.kennycason.kumo.CollisionMode
import com.kennycason.kumo.WordCloud
import com.kennycason.kumo.bg.PixelBoundryBackground
import com.kennycason.kumo.font.scale.LinearFontScalar
import com.kennycason.kumo.nlp.FrequencyAnalyzer
import com.kennycason.kumo.nlp.tokenizer.NoTokenizer
import com.kennycason.kumo.palette.ColorPalette
import java.awt.Color
import java.awt.Dimension


fun main(args: Array<String>) {
    val frequencyAnalyzer = FrequencyAnalyzer()
    frequencyAnalyzer.setWordTokenizer(NoTokenizer())
    val wordFrequencies = frequencyAnalyzer.load("src/main/resources/thimmwork_skills.txt")
    val dimension = Dimension(460, 460)
    val wordCloud = WordCloud(dimension, CollisionMode.PIXEL_PERFECT)
    val backgroundImage = PixelBoundryBackground("src/main/resources/images/a_little_silhouette_of_a_man.png")
    wordCloud.setBackground(backgroundImage)
    wordCloud.setPadding(0)
    wordCloud.setColorPalette(ColorPalette(Color.BLACK, Color.DARK_GRAY, Color.GRAY, Color.LIGHT_GRAY))
    wordCloud.setFontScalar(LinearFontScalar(8, 60))
    wordCloud.setBackgroundColor(Color.WHITE)
    wordCloud.build(wordFrequencies)
    wordCloud.writeToFile("target/wordcloud_rectangle.png")
}
