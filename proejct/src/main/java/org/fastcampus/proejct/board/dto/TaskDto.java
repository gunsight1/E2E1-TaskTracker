package org.fastcampus.proejct.board.dto;

import org.fastcampus.proejct.board.domain.Board;
import org.fastcampus.proejct.board.domain.Task;
import org.fastcampus.proejct.user.domain.UserInfo;
import org.fastcampus.proejct.user.dto.UserInfoDto;

import java.time.LocalDateTime;

/**
 * DTO for {@link org.fastcampus.proejct.board.domain.Task}
 */
public record TaskDto(
        Long id,
        String content,
        String worker,
        boolean isFinished,
        LocalDateTime startDate,
        LocalDateTime endDate,
        BoardDto board,
//        UserInfoDto userInfo,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy
) {
    public static TaskDto of(
            Long id,
            String content,
            String worker,
            boolean isFinished,
            LocalDateTime startDate,
            LocalDateTime endDate,
            BoardDto board,
//            UserInfoDto userInfo,
            LocalDateTime createdAt,
            String createdBy,
            LocalDateTime modifiedAt,
            String modifiedBy
    ) {
        return new TaskDto(
                id,
                content,
                worker,
                isFinished,
                startDate,
                endDate,
                board,
//                userInfo,
                createdAt,
                createdBy,
                modifiedAt,
                modifiedBy
        );
    }

    public static TaskDto from(Task entity) {
        return TaskDto.of(
                entity.getId(),
                entity.getContent(),
                entity.getWorker(),
                entity.isFinished(),
                entity.getStartDate(),
                entity.getEndDate(),
                BoardDto.from(entity.getBoard()),
//                UserInfoDto.from(entity.getUserInfo()),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy()
        );
    }

    public Task toEntity(Board board) {
        return Task.of(
                id,
                content,
                worker,
                isFinished,
                startDate,
                endDate,
                board
//                userInfo
        );
    }
}