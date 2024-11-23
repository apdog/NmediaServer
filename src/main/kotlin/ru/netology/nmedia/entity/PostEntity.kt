package ru.netology.nmedia.entity

import ru.netology.nmedia.dto.Post
import jakarta.persistence.Id
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType

@Entity
data class PostEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long,
    val author: Long,
    val date: Long,
    val title: String,
    var content: String?,
    val friendsOnly: Boolean,
    val comments: Int = 0,
    var likes: Int,
    var likedByMe: Boolean = false,
    val reposts: Int,
    val views: Int,
    val isPinned: Boolean,
) {
    fun toDto(): Post = Post(
        id = id,
        author = author,
        date = date,
        title = title,
        content = content,
        friendsOnly = friendsOnly,
        comments = comments,
        likes = likes,
        likedByMe = likedByMe,
        reposts = reposts,
        views = views,
        isPinned = isPinned,
    )

    companion object {
        fun fromDto(dto: Post): PostEntity = with(dto) {
            PostEntity(
                id,
                author,
                date,
                title = title.ifBlank { "Нетология" },
                content,
                friendsOnly,
                comments,
                likes,
                likedByMe,
                reposts,
                views,
                isPinned,

                )
        }
    }
}