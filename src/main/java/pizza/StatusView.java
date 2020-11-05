package pizza;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="StatusView_table")
public class StatusView {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Long orderId;
        private String orderStatus;
        private String deliveryStatus;
        private Long score;
        private String gradeStatus;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public Long getOrderId() {
            return orderId;
        }

        public void setOrderId(Long orderId) {
            this.orderId = orderId;
        }
        public String getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }
        public String getDeliveryStatus() {
            return deliveryStatus;
        }

        public void setDeliveryStatus(String deliveryStatus) {
            this.deliveryStatus = deliveryStatus;
        }
        public Long getScore() {
            return score;
        }

        public void setScore(Long score) {
            this.score = score;
        }
        public String getGradeStatus() {
            return gradeStatus;
        }

        public void setGradeStatus(String gradeStatus) {
            this.gradeStatus = gradeStatus;
        }

}
