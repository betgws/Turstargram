package umc.thurstagram.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.thurstagram.apipayload.ApiResponse;
import umc.thurstagram.web.dto.request.CommentCreateRequest;
import umc.thurstagram.web.dto.response.CommentCreateResponse;
import umc.thurstagram.service.CommentService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("{postId}/comment")
    public ApiResponse<CommentCreateResponse> writeComment(
            @PathVariable Long postId,
            @RequestBody CommentCreateRequest commentCreateRequest){
        return ApiResponse.onSuccess(commentService.writeComment(postId, commentCreateRequest));
    }

    @DeleteMapping("/{commentId}")
    public ApiResponse<?> deleteComment(@PathVariable Long commentId){
        commentService.deleteByCommentId(commentId);
        return ApiResponse.onSuccess("댓글 삭제됨");
    }

    @PostMapping("{commentId}/recomment")
    public ApiResponse<CommentCreateResponse> writeRecomment(
            @PathVariable Long commentId,
            @RequestBody CommentCreateRequest commentCreateRequest){
        return ApiResponse.onSuccess(commentService.writeRecomment(commentId, commentCreateRequest));
    }

    @DeleteMapping("/{recommentId}")
    public ApiResponse<?> deleteRecomment(@PathVariable Long recommentId){
        commentService.deleteByRecommentId(recommentId);
        return ApiResponse.onSuccess("댓글 삭제됨");
    }
}
