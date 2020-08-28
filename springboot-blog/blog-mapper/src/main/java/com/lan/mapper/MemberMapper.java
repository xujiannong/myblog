package com.lan.mapper;

import com.lan.domain.Member;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface MemberMapper {

    List<Member> getMemberByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("emp") Member member, @Param("beginDateScope") Date[] beginDateScope);

}
