﻿1. Phần CSDL. Lấy file QuanLyVatTuYTe về
- tạo 1 database có tên QuanLyVatTuYte
- sau đó click chuột phải vào database vừa tạo, chọn Tasks -> Restore -> Database..
- Chọn tên Database cần restore ở chỗ "To Database"
- Chọn file .bak vừa tải về ở chỗ "From device" - >Add -> Chọn tới đường dẫn chưa file .bak ->OK
- Tích chọn file ở "Select the backup sets to restore" -> OK.
--Xong phần Database
- Phần của ai thì người đó tự thêm dữ liệu vào để test nhé.


2. Phần Code.
- Những Frame nào không cần hiển thị ở màn hình chính thì cứ tạo Frame bình thường, nhưng nhớ bỏ cái main đi, và đặt "this.setVisible(true)" vào chỗ constructor là đc.
- Những màn hình nào cần hiển thị chung ở màn hình chính, thì chỗ constructor thì làm tương tự như sau:
	public DanhSachNguoiDung(JPanel contentPane) {
		//dùng contentPane để add cái thành phần khác
	}
 Chỗ bắt sự kiện khi click vào các item, thì đặt tương tự như ri là đc
	if(e.getSource() == itemDanhSachNguoiDung){
			mainPane.add(this,new DanhSachNguoiDung(mainPane));
	}


3. Tất cả các image liên quan đến project thì nên đặt chung vào 1 thư mục images ở trong đó luôn nghe.
	Đặt đường dẫn thì nhớ đừng đặt đường dẫn tuyệt đối đó. khổ lắm.

==> éo biết giải thích thế nào nữa :=))
