package fyc.epss.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusinessExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BusinessExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAidIsNull() {
            addCriterion("aid is null");
            return (Criteria) this;
        }

        public Criteria andAidIsNotNull() {
            addCriterion("aid is not null");
            return (Criteria) this;
        }

        public Criteria andAidEqualTo(Integer value) {
            addCriterion("aid =", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotEqualTo(Integer value) {
            addCriterion("aid <>", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThan(Integer value) {
            addCriterion("aid >", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThanOrEqualTo(Integer value) {
            addCriterion("aid >=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThan(Integer value) {
            addCriterion("aid <", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThanOrEqualTo(Integer value) {
            addCriterion("aid <=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidIn(List<Integer> values) {
            addCriterion("aid in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotIn(List<Integer> values) {
            addCriterion("aid not in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidBetween(Integer value1, Integer value2) {
            addCriterion("aid between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotBetween(Integer value1, Integer value2) {
            addCriterion("aid not between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andBusinessnameIsNull() {
            addCriterion("businessName is null");
            return (Criteria) this;
        }

        public Criteria andBusinessnameIsNotNull() {
            addCriterion("businessName is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessnameEqualTo(String value) {
            addCriterion("businessName =", value, "businessname");
            return (Criteria) this;
        }

        public Criteria andBusinessnameNotEqualTo(String value) {
            addCriterion("businessName <>", value, "businessname");
            return (Criteria) this;
        }

        public Criteria andBusinessnameGreaterThan(String value) {
            addCriterion("businessName >", value, "businessname");
            return (Criteria) this;
        }

        public Criteria andBusinessnameGreaterThanOrEqualTo(String value) {
            addCriterion("businessName >=", value, "businessname");
            return (Criteria) this;
        }

        public Criteria andBusinessnameLessThan(String value) {
            addCriterion("businessName <", value, "businessname");
            return (Criteria) this;
        }

        public Criteria andBusinessnameLessThanOrEqualTo(String value) {
            addCriterion("businessName <=", value, "businessname");
            return (Criteria) this;
        }

        public Criteria andBusinessnameLike(String value) {
            addCriterion("businessName like", value, "businessname");
            return (Criteria) this;
        }

        public Criteria andBusinessnameNotLike(String value) {
            addCriterion("businessName not like", value, "businessname");
            return (Criteria) this;
        }

        public Criteria andBusinessnameIn(List<String> values) {
            addCriterion("businessName in", values, "businessname");
            return (Criteria) this;
        }

        public Criteria andBusinessnameNotIn(List<String> values) {
            addCriterion("businessName not in", values, "businessname");
            return (Criteria) this;
        }

        public Criteria andBusinessnameBetween(String value1, String value2) {
            addCriterion("businessName between", value1, value2, "businessname");
            return (Criteria) this;
        }

        public Criteria andBusinessnameNotBetween(String value1, String value2) {
            addCriterion("businessName not between", value1, value2, "businessname");
            return (Criteria) this;
        }

        public Criteria andBusinessaddressIsNull() {
            addCriterion("businessAddress is null");
            return (Criteria) this;
        }

        public Criteria andBusinessaddressIsNotNull() {
            addCriterion("businessAddress is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessaddressEqualTo(String value) {
            addCriterion("businessAddress =", value, "businessaddress");
            return (Criteria) this;
        }

        public Criteria andBusinessaddressNotEqualTo(String value) {
            addCriterion("businessAddress <>", value, "businessaddress");
            return (Criteria) this;
        }

        public Criteria andBusinessaddressGreaterThan(String value) {
            addCriterion("businessAddress >", value, "businessaddress");
            return (Criteria) this;
        }

        public Criteria andBusinessaddressGreaterThanOrEqualTo(String value) {
            addCriterion("businessAddress >=", value, "businessaddress");
            return (Criteria) this;
        }

        public Criteria andBusinessaddressLessThan(String value) {
            addCriterion("businessAddress <", value, "businessaddress");
            return (Criteria) this;
        }

        public Criteria andBusinessaddressLessThanOrEqualTo(String value) {
            addCriterion("businessAddress <=", value, "businessaddress");
            return (Criteria) this;
        }

        public Criteria andBusinessaddressLike(String value) {
            addCriterion("businessAddress like", value, "businessaddress");
            return (Criteria) this;
        }

        public Criteria andBusinessaddressNotLike(String value) {
            addCriterion("businessAddress not like", value, "businessaddress");
            return (Criteria) this;
        }

        public Criteria andBusinessaddressIn(List<String> values) {
            addCriterion("businessAddress in", values, "businessaddress");
            return (Criteria) this;
        }

        public Criteria andBusinessaddressNotIn(List<String> values) {
            addCriterion("businessAddress not in", values, "businessaddress");
            return (Criteria) this;
        }

        public Criteria andBusinessaddressBetween(String value1, String value2) {
            addCriterion("businessAddress between", value1, value2, "businessaddress");
            return (Criteria) this;
        }

        public Criteria andBusinessaddressNotBetween(String value1, String value2) {
            addCriterion("businessAddress not between", value1, value2, "businessaddress");
            return (Criteria) this;
        }

        public Criteria andBusinessexplainIsNull() {
            addCriterion("businessExplain is null");
            return (Criteria) this;
        }

        public Criteria andBusinessexplainIsNotNull() {
            addCriterion("businessExplain is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessexplainEqualTo(String value) {
            addCriterion("businessExplain =", value, "businessexplain");
            return (Criteria) this;
        }

        public Criteria andBusinessexplainNotEqualTo(String value) {
            addCriterion("businessExplain <>", value, "businessexplain");
            return (Criteria) this;
        }

        public Criteria andBusinessexplainGreaterThan(String value) {
            addCriterion("businessExplain >", value, "businessexplain");
            return (Criteria) this;
        }

        public Criteria andBusinessexplainGreaterThanOrEqualTo(String value) {
            addCriterion("businessExplain >=", value, "businessexplain");
            return (Criteria) this;
        }

        public Criteria andBusinessexplainLessThan(String value) {
            addCriterion("businessExplain <", value, "businessexplain");
            return (Criteria) this;
        }

        public Criteria andBusinessexplainLessThanOrEqualTo(String value) {
            addCriterion("businessExplain <=", value, "businessexplain");
            return (Criteria) this;
        }

        public Criteria andBusinessexplainLike(String value) {
            addCriterion("businessExplain like", value, "businessexplain");
            return (Criteria) this;
        }

        public Criteria andBusinessexplainNotLike(String value) {
            addCriterion("businessExplain not like", value, "businessexplain");
            return (Criteria) this;
        }

        public Criteria andBusinessexplainIn(List<String> values) {
            addCriterion("businessExplain in", values, "businessexplain");
            return (Criteria) this;
        }

        public Criteria andBusinessexplainNotIn(List<String> values) {
            addCriterion("businessExplain not in", values, "businessexplain");
            return (Criteria) this;
        }

        public Criteria andBusinessexplainBetween(String value1, String value2) {
            addCriterion("businessExplain between", value1, value2, "businessexplain");
            return (Criteria) this;
        }

        public Criteria andBusinessexplainNotBetween(String value1, String value2) {
            addCriterion("businessExplain not between", value1, value2, "businessexplain");
            return (Criteria) this;
        }

        public Criteria andStarpriceIsNull() {
            addCriterion("starPrice is null");
            return (Criteria) this;
        }

        public Criteria andStarpriceIsNotNull() {
            addCriterion("starPrice is not null");
            return (Criteria) this;
        }

        public Criteria andStarpriceEqualTo(BigDecimal value) {
            addCriterion("starPrice =", value, "starprice");
            return (Criteria) this;
        }

        public Criteria andStarpriceNotEqualTo(BigDecimal value) {
            addCriterion("starPrice <>", value, "starprice");
            return (Criteria) this;
        }

        public Criteria andStarpriceGreaterThan(BigDecimal value) {
            addCriterion("starPrice >", value, "starprice");
            return (Criteria) this;
        }

        public Criteria andStarpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("starPrice >=", value, "starprice");
            return (Criteria) this;
        }

        public Criteria andStarpriceLessThan(BigDecimal value) {
            addCriterion("starPrice <", value, "starprice");
            return (Criteria) this;
        }

        public Criteria andStarpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("starPrice <=", value, "starprice");
            return (Criteria) this;
        }

        public Criteria andStarpriceIn(List<BigDecimal> values) {
            addCriterion("starPrice in", values, "starprice");
            return (Criteria) this;
        }

        public Criteria andStarpriceNotIn(List<BigDecimal> values) {
            addCriterion("starPrice not in", values, "starprice");
            return (Criteria) this;
        }

        public Criteria andStarpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("starPrice between", value1, value2, "starprice");
            return (Criteria) this;
        }

        public Criteria andStarpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("starPrice not between", value1, value2, "starprice");
            return (Criteria) this;
        }

        public Criteria andDeliverypriceIsNull() {
            addCriterion("deliveryPrice is null");
            return (Criteria) this;
        }

        public Criteria andDeliverypriceIsNotNull() {
            addCriterion("deliveryPrice is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverypriceEqualTo(BigDecimal value) {
            addCriterion("deliveryPrice =", value, "deliveryprice");
            return (Criteria) this;
        }

        public Criteria andDeliverypriceNotEqualTo(BigDecimal value) {
            addCriterion("deliveryPrice <>", value, "deliveryprice");
            return (Criteria) this;
        }

        public Criteria andDeliverypriceGreaterThan(BigDecimal value) {
            addCriterion("deliveryPrice >", value, "deliveryprice");
            return (Criteria) this;
        }

        public Criteria andDeliverypriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("deliveryPrice >=", value, "deliveryprice");
            return (Criteria) this;
        }

        public Criteria andDeliverypriceLessThan(BigDecimal value) {
            addCriterion("deliveryPrice <", value, "deliveryprice");
            return (Criteria) this;
        }

        public Criteria andDeliverypriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("deliveryPrice <=", value, "deliveryprice");
            return (Criteria) this;
        }

        public Criteria andDeliverypriceIn(List<BigDecimal> values) {
            addCriterion("deliveryPrice in", values, "deliveryprice");
            return (Criteria) this;
        }

        public Criteria andDeliverypriceNotIn(List<BigDecimal> values) {
            addCriterion("deliveryPrice not in", values, "deliveryprice");
            return (Criteria) this;
        }

        public Criteria andDeliverypriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deliveryPrice between", value1, value2, "deliveryprice");
            return (Criteria) this;
        }

        public Criteria andDeliverypriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deliveryPrice not between", value1, value2, "deliveryprice");
            return (Criteria) this;
        }

        public Criteria andUptimeIsNull() {
            addCriterion("uptime is null");
            return (Criteria) this;
        }

        public Criteria andUptimeIsNotNull() {
            addCriterion("uptime is not null");
            return (Criteria) this;
        }

        public Criteria andUptimeEqualTo(Date value) {
            addCriterion("uptime =", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeNotEqualTo(Date value) {
            addCriterion("uptime <>", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeGreaterThan(Date value) {
            addCriterion("uptime >", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeGreaterThanOrEqualTo(Date value) {
            addCriterion("uptime >=", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeLessThan(Date value) {
            addCriterion("uptime <", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeLessThanOrEqualTo(Date value) {
            addCriterion("uptime <=", value, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeIn(List<Date> values) {
            addCriterion("uptime in", values, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeNotIn(List<Date> values) {
            addCriterion("uptime not in", values, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeBetween(Date value1, Date value2) {
            addCriterion("uptime between", value1, value2, "uptime");
            return (Criteria) this;
        }

        public Criteria andUptimeNotBetween(Date value1, Date value2) {
            addCriterion("uptime not between", value1, value2, "uptime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}