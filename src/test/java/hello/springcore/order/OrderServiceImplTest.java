package hello.springcore.order;

import hello.springcore.discount.RateDiscountPolicy;
import hello.springcore.member.Grade;
import hello.springcore.member.Member;
import hello.springcore.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder(){
        MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
        Member member = new Member(1L, "abac", Grade.VIP);
        memoryMemberRepository.save(member);

        OrderServiceImpl orderService = new OrderServiceImpl(memoryMemberRepository, new RateDiscountPolicy());

        Order order = orderService.createOrder(1L, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}