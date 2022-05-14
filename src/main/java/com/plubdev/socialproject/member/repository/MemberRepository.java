package com.plubdev.socialproject.member.repository;

import com.plubdev.socialproject.member.domain.LoginType;
import com.plubdev.socialproject.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByLoginTypeAndLoginId(LoginType loginType, String loginId);
}
