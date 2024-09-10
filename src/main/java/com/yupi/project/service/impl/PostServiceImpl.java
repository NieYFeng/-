package com.yupi.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.project.common.ErrorCode;
import com.yupi.project.exception.BusinessException;
import com.yupi.project.mapper.PostMapper;
import com.yupi.project.model.dto.post.PostQueryRequest;
import com.yupi.project.model.entity.Post;
import com.yupi.project.model.enums.PostGenderEnum;
import com.yupi.project.model.enums.PostReviewStatusEnum;
import com.yupi.project.service.PostService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author nyf
 * @description 针对表【post(帖子)】的数据库操作Service实现
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {

    @Autowired
    private PostMapper postMapper;

    @Override
    public void validPost(Post post, boolean add) {
        if (post == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String content = post.getContent();
        // 创建时，所有参数必须非空
        if (add) {
            if (StringUtils.isAnyBlank(content)) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }
        }
        if (StringUtils.isNotBlank(content) && content.length() > 8192) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "内容过长");
        }
    }
    @Override
    public List<Post> getCursorPage(PostQueryRequest postQueryRequest){
        if(postQueryRequest==null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        long lastId = postQueryRequest.getLastId();
        long pageSize = postQueryRequest.getPageSize();
        return postMapper.selectCursorPage(lastId, pageSize);
    }

}




