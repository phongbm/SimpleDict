# SimpleDict

Mô tả ngắn gọn:
Bạn cần cài một chương trình từ điển mini cho phép người dùng tra từ, thêm mục từ / nghĩa mới, xóa mục từ, và lưu lại các sửa đổi của mình. Dữ liệu từ điển được đặt trong một file text và được nạp khi chương trình bắt đầu chạy. Chương trình chạy trong cửa sổ lệnh DOS, người dùng dùng bàn phím (input chuẩn) để nhập lệnh tra cứu/thêm/xóa/lưu, kết quả được hiển thị bằng output chuẩn.

Cú pháp lệnh và định dạng file, định dạng output cần theo quy định của đề bài, chính xác đến từng kí tự.
Yêu cầu chức năng:

Từ điển nạp dữ liệu từ file có tên DICT.DAT (charsetName="Unicode" - mã Unicode) với định dạng như sau: Mỗi mục từ nằm trên 1 dòng với cú pháp:

<word>:<space><meanings>

trong đó, <word> là một chuỗi kí tự không chứa dấu hai chấm ":"; <space> chỉ bao gồm đúng 01 kí tự space; <meanings> là chuỗi kí tự kéo dài cho đến hết dòng.
Người dùng đảm bảo sự tồn tại của file dữ liệu nằm tại thư mục nơi chạy chương trình, dữ liệu trong file là hợp lệ. Tuy nhiên, các mục từ trong file không được xếp theo thứ tự từ điển, không có giới hạn về số mục từ.

Từ điển cần đáp ứng các lệnh sau do người dùng gõ vào tại dấu nhắc:
Lệnh	Công việc chương trình cần thực hiện

save

	lưu nội dung từ điển ra tệp DICT.DAT theo thứ tự từ điển, với định dạng như đã quy định

add<space><word>:<space><meanings>

	Nếu trong từ điển đã có mục từ dành <word> thì nối thêm "; "<meanings> vào đuôi của meanings sẵn có trong mục từ đó. Nếu chưa có thì bổ sung mục từ mới.

lookup<space><word>

	tìm <word> trong từ điển. Nếu tìm thấy thì in meaning trên một dòng (không được thừa hay thiếu dấu cách). Nếu không thì in ra thông báo "Not found." trên một dòng

delete<space><word>

	xóa mục từ <word> trong từ điển. Nếu tìm thấy và xóa thì in thông báo "<word> deleted." trên một dòng (không được thừa hay thiếu dấu cách). Nếu không thì in ra thông báo "Not found." trên một dòng.

quit

	ngừng chương trình