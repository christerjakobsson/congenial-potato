package hello.Repositories;

import hello.Models.Session;

import java.util.UUID;

public interface SessionRepositoryCustom {
    Session findByUserId(UUID id);
}
