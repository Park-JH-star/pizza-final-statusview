package pizza;

import pizza.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class StatusViewViewHandler {


    @Autowired
    private StatusViewRepository statusViewRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrdered_then_CREATE_1 (@Payload Ordered ordered) {
        try {
            if (ordered.isMe()) {
                // view 객체 생성
                StatusView statusView = new StatusView();
                // view 객체에 이벤트의 Value 를 set 함
                statusView.setOrderId(ordered.getId());
                statusView.setOrderStatus(ordered.getOrderStatus());
                // view 레파지 토리에 save
                statusViewRepository.save(statusView);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenGraded_then_CREATE_2 (@Payload Graded graded) {
        try {
            if (graded.isMe()) {
                // view 객체 생성
                StatusView statusView = new StatusView();
                // view 객체에 이벤트의 Value 를 set 함
                statusView.setOrderId(graded.getOrderId());
                statusView.setScore(graded.getScore());
                statusView.setGradeStatus(graded.getGradeStatus());
                // view 레파지 토리에 save
                statusViewRepository.save(statusView);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaymentCanceled_then_UPDATE_1(@Payload PaymentCanceled paymentCanceled) {
        try {
            if (paymentCanceled.isMe()) {
                // view 객체 조회
                List<StatusView> statusViewList = statusViewRepository.findByOrderId(paymentCanceled.getOrderId());
                for(StatusView statusView : statusViewList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    statusView.setOrderStatus(paymentCanceled.getPaymentStatus());
                    statusView.setOrderId(paymentCanceled.getOrderId());
                    // view 레파지 토리에 save
                    statusViewRepository.save(statusView);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDelivered_then_UPDATE_2(@Payload Delivered delivered) {
        try {
            if (delivered.isMe()) {
                // view 객체 조회
                List<StatusView> statusViewList = statusViewRepository.findByOrderId(delivered.getOrderId());
                for(StatusView statusView : statusViewList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    statusView.setDeliveryStatus(delivered.getDeliveryStatus());
                    statusView.setOrderId(delivered.getOrderId());
                    // view 레파지 토리에 save
                    statusViewRepository.save(statusView);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCanceled_then_UPDATE_3(@Payload OrderCanceled orderCanceled) {
        try {
            if (orderCanceled.isMe()) {
                // view 객체 조회
                List<StatusView> statusViewList = statusViewRepository.findByOrderId(orderCanceled.getId());
                for(StatusView statusView : statusViewList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    statusView.setOrderStatus(orderCanceled.getOrderStatus());
                    statusView.setOrderId(orderCanceled.getId());
                    // view 레파지 토리에 save
                    statusViewRepository.save(statusView);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}