package nal.test.planning.constant;

/**
 * Constant of project
 * @author TuanNH
 */
public class Constant {

    public static class CodeResponse {
        public static int OK = 200;
        public static int BAD_REQUEST = 400;
    }

    public static class FormatDate {
        public static String ddMMyyyy_1 = "dd/MM/yyyy";
    }

    public static class MessageCommon {
        public static String SUCCESS = "Thành công";
        public static String WORK_NOT_EXIST = "Work không tồn tại.";
        public static String WORK_EXIST = "Work đã tồn tại.";
        public static String DEL_SUCCESS = "Xóa work thành công.";
        public static String ADD_SUCCESS = "Thêm mới thành công.";
        public static String UPDATE_SUCCESS = "Sửa đổi thành công.";
        
        public static String NOT_EMPTY_WORK_NAME = "Không được để trống tên công việc.";
        public static String NOT_EMPTY_STARTING_DATE = "Không được để trống ngày bắt đầu.";
        public static String NOT_EMPTY_ENDING_DATE = "Không được để trống ngày kết thúc.";
        public static String NOT_EMPTY_STATUS = "Không được để trạng thái.";
        public static String CHOSSE_STATUS = "Trạng thái không đúng (Planning, Doing, Complete).";

        public static String FORMAT_STARTING_DATE = "Sai định dạng ngày bắt đầu.";
        public static String FORMAT_ENDING_DATE = "Sai định dạng ngày kết thúc.";
        public static String STARTING_AFTER_ENDING_DATE = "Ngày bắt đầu không lớn hơn ngày kết thúc.";
    }
    
    
}
