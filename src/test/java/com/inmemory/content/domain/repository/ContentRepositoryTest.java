package com.inmemory.content.domain.repository;

import com.inmemory.content.domain.aggregate.Content;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class ContentRepositoryTest {

    @Autowired
    private ContentRepository contentRepository;

    @Test
    @DisplayName("Content 조회에 성공한다.")
    void content_get_success() {
        //  given
        Content content = Content.builder()
                .contentNo("testContentNo")
                .build();
        contentRepository.save(content);

        //  when
        Optional<Content> result = contentRepository.findByContentNo(content.getContentNo());

        //  then
        assertTrue(result.isPresent());
        Content actual = result.get();
        assertThat(actual.getContentId()).isEqualTo(content.getContentId());
    }

}