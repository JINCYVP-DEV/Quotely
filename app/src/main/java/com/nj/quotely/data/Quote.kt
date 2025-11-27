package com.nj.quotely.data

import androidx.compose.ui.graphics.Color

data class Quote(
    val id: Int,
    val text: String,
    val author: String,
    val category: QuoteCategory,
    val color: Color,
    val avatar: String = "👤",
    var isSaved: Boolean =false
) {
    companion object {
        fun getQuotes(): List<Quote> {
            return listOf(
                Quote(
                    1,
                    "Never forget those that helped before you even had to ask",
                    "ig-glossy_minds",
                    QuoteCategory.LIFE,
                      Color(0xFF1E40AF)
                ),
                Quote(
                    2,
                    "Everything you can imagine is real",
                    "Pablo Picasso",
                    QuoteCategory.MOTIVATION,
                    Color(0xFFCFD8DC)
                ),
                Quote(
                    3,
                    "The price of greatness is responsibility",
                    "ig-glossy_minds",
                    QuoteCategory.LEADERSHIP,
                    Color(0xFFDCE775)
                ),
                Quote(
                    4,
                    "When life gives you monday, dip it in glitter and sparkle all day",
                    "Ella Woodward",
                    QuoteCategory.LIFE,
                    Color(0xFFB39DDB)
                ),
                Quote(
                    5,
                    "Action without thought is empty. Thought without action is blind.",
                    "Kwame Nkrumah",
                    QuoteCategory.WISDOM,
                    Color(0xFFFBC02D)
                ),
                Quote(
                    6,
                    "Do what you feel in your heart to be right - for you will be criticized anyway",
                    "Eleanor Roosevelt",
                    QuoteCategory.COURAGE,
                    Color(0xFFF48FB1)
                ),
                Quote(
                    7,
                    "Do one thing everyday that scares you",
                    "Pablo Picasso",
                    QuoteCategory.COURAGE,
                    Color(0xFF90A4AE)
                ),
                Quote(
                    8,
                    "The only way to do great work is to love what you do.",
                    "Steve Jobs",
                    QuoteCategory.SUCCESS,
                    Color(0xFFFBC02D)
                ),
                Quote(
                    9,
                    "Believe you can and you're halfway there.",
                    "Theodore Roosevelt",
                    QuoteCategory.MOTIVATION,
                    Color(0xFFC5E1A5)
                ),
                Quote(
                    10,
                    "Success is not final, failure is not fatal.",
                    "Winston Churchill",
                    QuoteCategory.SUCCESS,
                            Color(0xFFFF8A65)
                ),
                Quote(
                    11,
                    "The future belongs to those who believe in the beauty of their dreams.",
                    "Eleanor Roosevelt",
                    QuoteCategory.MOTIVATION,
                    Color(0xFF1E40AF)
                ),
                Quote(
                    12,
                    "It is during our darkest moments that we must focus to see the light.",
                    "Aristotle",
                    QuoteCategory.WISDOM,
                    Color(0xFFF48FB1)
                ),
                Quote(13, "Everything you can imagine is real", "Unknown",
                    QuoteCategory.LIFE,
                    Color(0xFFDCE775)
                    ),
                Quote(
                    14,
                    "Love is the most beautiful thing in the world.",
                    "Unknown",
                    QuoteCategory.LOVE,
                    Color(0xFFDCE775)
                ),
                Quote(
                    15,
                    "A leader is one who knows the way, goes the way.",
                    "John C. Maxwell",
                    QuoteCategory.LEADERSHIP,
                    Color(0xFFB39DDB)

                ),
                Quote(
                    16,
                    "The journey of a thousand miles begins with a single step.",
                    "Lao Tzu",
                    QuoteCategory.WISDOM,
                    Color(0xFFFF8A65)
                ),
                Quote(
                    17,
                    "Innovation distinguishes between a leader and a follower.",
                    "Steve Jobs",
                    QuoteCategory.LEADERSHIP,
                    Color(0xFF90A4AE)
                ),
                Quote(
                    18,
                    "Your time is limited, don't waste it.",
                    "Steve Jobs",
                    QuoteCategory.LIFE,
                    Color(0xFFFBC02D)
                ),
                Quote(
                    19,
                    "The only impossible journey is the one you never begin.",
                    "Tony Robbins",
                    QuoteCategory.MOTIVATION,
                    Color(0xFFA5D6FB)

                ),
                Quote(
                    20,
                    "Life is what happens when you're busy making other plans.",
                    "John Lennon",
                    QuoteCategory.LIFE,
                    Color(0xFFF48FB1)
                )
            )
        }
    }
}
