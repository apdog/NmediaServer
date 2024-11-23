package ru.netology.nmedia.dto

data class Post(
    val id: Long, // Уникальный номер поста
    val author: Long, // ID автора поста
    val date: Long, // Дата публикации поста
    val title: String, // Заголовок поста
    val content: String?, // Текст поста
    val friendsOnly: Boolean, // Если пост виден только друзьям
    val comments: Int = 0, // Информация о комментариях
    val likes: Int, // Информация о лайках
    val likedByMe: Boolean = false, // Лайкнул ли я пост
    val reposts: Int, // Информация о репостах
    val views: Int, // Информация о просмотрах
    val isPinned: Boolean // Закреплен ли пост
)