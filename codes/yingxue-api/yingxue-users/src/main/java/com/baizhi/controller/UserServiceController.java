package com.baizhi.controller;

import com.baizhi.entity.Comment;
import com.baizhi.entity.Favorite;
import com.baizhi.entity.User;
import com.baizhi.service.CommentService;
import com.baizhi.service.FavoriteService;
import com.baizhi.service.UserService;
import com.baizhi.utils.JSONUtils;
import com.baizhi.vo.CommentVO;
import com.baizhi.vo.Reviewer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserServiceController {

    private static final Logger log = LoggerFactory.getLogger(UserServiceController.class);
    @Autowired
    private UserService userService;

    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private CommentService commentService;

    //根据用户id返回用户信息服务
    @GetMapping("/userInfo/{id}")
    public User user(@PathVariable("id") String id) {
        log.info("接收到用户id: {}", id);
        User user = userService.queryById(Integer.valueOf(id));
        log.info("返回的用户信息: {}", JSONUtils.writeValueAsString(user));
        return user;
    }

    /**
     * 根据用户id视频id查询是否收藏
     *
     * @param videoId
     * @param userId
     * @return
     */
    @GetMapping("/userInfo/favorite")
    public Favorite favorite(@RequestParam("videoId") String videoId, @RequestParam("userId") String userId) {
        log.info("接收到的视频id {}, 用户id: {}", videoId, userId);
        Favorite favorite = favoriteService.queryByVideoIdAndUserId(Integer.valueOf(videoId), Integer.valueOf(userId));
        log.info("当前返回的收藏对象是否为空: {}", ObjectUtils.isEmpty(favorite));
        return favorite;
    }


    /**
     * 用户发表评论信息
     */
    @PostMapping("/user/comment/{userId}/{videoId}")
    public void comments(@PathVariable("userId") Integer userId, @PathVariable("videoId") Integer videoId, @RequestBody Comment comment) {
        //接受到评论
        log.info("视频id: {}", videoId);
        log.info("评论信息: {}", JSONUtils.writeValueAsString(comment));
        log.info("评论用户信息: {}", userId);
        //设置评论用户信息
        comment.setUid(userId);
        //设置评论视频
        comment.setVideoId(videoId);
        commentService.insert(comment);
    }


    /**
     * 视频评论
     */
    @GetMapping("/user/comments")
    public Map<String, Object> comments(@RequestParam("videoId") Integer videoId,
                                        @RequestParam(value = "page", defaultValue = "1") Integer page,
                                        @RequestParam(value = "per_page", defaultValue = "15") Integer rows) {
        log.info("视频id: {}", videoId);
        log.info("当前页: {}", page);
        log.info("每页显示记录数: {}", rows);
        Map<String, Object> result = new HashMap<>();

        //1.根据视频id分页查询当前视频下评论内容
        Long total_counts = commentService.findByVideoIdCounts(videoId);
        result.put("total_count", total_counts);

        //2.根据视频id分页获取对应评论信息以及子评论信息
        List<CommentVO> commentVOList = new ArrayList<>();
        //3.根据视频id分页获取父评论信息
        List<Comment> comments = commentService.findByVideoId(videoId, page, rows);

        //4.遍历父评论信息
        comments.forEach(comment -> {
            //5.将评论信息转为commentVO
            CommentVO commentVO = new CommentVO();
            //6.属性拷贝  commentvo id content createAt
            BeanUtils.copyProperties(comment, commentVO);
            //7.获取评论作者信息
            Reviewer reviewer = new Reviewer();
            //8.根据评论用户id查询用户信息
            User user = userService.queryById(comment.getUid());
            //9.将用户信息 赋值 reviewer对象中  id name avtar
            BeanUtils.copyProperties(user, reviewer);
            //10.设置评论信息
            commentVO.setReviewer(reviewer);
            //11.设置子评论内容
            List<Comment> childComments = commentService.findByParentId(comment.getId());
            List<CommentVO> childCommentVOS = new ArrayList<>();
            childComments.forEach(commentChild -> {
                CommentVO commentChildVO = new CommentVO();
                BeanUtils.copyProperties(commentChild, commentChildVO);
                //12.设置评论用户信息
                User userChild = userService.queryById(commentChild.getUid());
                Reviewer reviewerChild = new Reviewer();
                BeanUtils.copyProperties(userChild, reviewerChild);
                commentChildVO.setReviewer(reviewerChild);
                childCommentVOS.add(commentChildVO);
            });
            //13.设置子评论
            commentVO.setSubComments(childCommentVOS);
            //14.放入list
            commentVOList.add(commentVO);
        });
        result.put("items", commentVOList);
        return result;
    }


}
