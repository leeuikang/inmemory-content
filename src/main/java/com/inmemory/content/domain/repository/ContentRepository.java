package com.inmemory.content.domain.repository;

import com.inmemory.content.domain.aggregate.Content;

import java.util.Optional;

public interface ContentRepository {
    public Optional<Content> findByContentNo(String contentNo);

    public Content save(Content content);
}
