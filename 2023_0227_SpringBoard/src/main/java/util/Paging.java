package util;
/*
        nowPage:����������
        rowTotal:��ü�����Ͱ���
        blockList:���������� �Խù���
        blockPage:��ȭ�鿡 ��Ÿ�� ������ ��ϼ�
 */
public class Paging {
	
	public static String getPaging(
								       String pageURL,
								       int nowPage, 
								       int rowTotal,
								       int blockList, 
								       int blockPage){
		
		int totalPage  /*��ü��������*/,
            startPage  /*������������ȣ*/,
            endPage;   /*��������������ȣ*/

		boolean  isPrevPage,isNextPage;
		StringBuffer sb; //��� ��Ȳ�� �Ǵ��Ͽ� HTML�ڵ带 ������ ��
		
		
		isPrevPage=isNextPage=false;
		//�Էµ� ��ü �ڿ��� ���� ��ü ������ ���� ���Ѵ�..
		totalPage = rowTotal/blockList;
		if(rowTotal%blockList!=0)totalPage++;
		

		//���� �߸��� ����� ���������� ���Ͽ� ���� ������ ���� ��ü ������ ����
		//���� ��� ������ ���������� ���� ��ü ������ ������ ����
		if(nowPage > totalPage)nowPage = totalPage;
		

		//���� �������� ������ �������� ����.
		startPage = ((nowPage-1)/blockPage)*blockPage + 1;
		endPage   = startPage + blockPage - 1; //
		
		//������ ������ ���� ��ü������������ ũ�� ������������ ���� ����
		if(endPage > totalPage)endPage = totalPage;
		
		//�������������� ��ü���������� ���� ��� ���� ����¡�� ������ �� �ֵ���
		//boolean�� ������ ���� ����
		if(endPage < totalPage) isNextPage = true;
		//������������ ���� 1���� ������ ��������¡ ������ �� �ֵ��� ������
		if(startPage > 1)isPrevPage = true;
		
		//HTML�ڵ带 ������ StringBuffer����=>�ڵ����
		sb = new StringBuffer();
		
		//css�޴� �߰�
		sb.append("<link rel='stylesheet' href='../resources/css/page_menu.css'>");
//-----�׷�������ó�� ���� --------------------------------------------------------------------------------------------		
		if(isPrevPage){
			
			/*
			 * sb.append("<a href ='"+pageURL+"?page="); 
			 * sb.append(startPage-1);
			 * sb.append("'>��</a>");
			 */
			
			sb.append(String.format("<a href='%s?page=%d'>��</a>", pageURL,startPage-1));
		}
		else
			sb.append("��");
		
//------������ ��� ��� -------------------------------------------------------------------------------------------------
		sb.append("|");
		for(int i=startPage; i<= endPage ;i++){
			
			if(i == nowPage){ //���� �ִ� ������
				sb.append("&nbsp;<b><font color='red'><span class='span_menu'>");
				sb.append(i);
				sb.append("</span></font></b>");
			}
			else{//���� �������� �ƴϸ�
				/*
				 * sb.append("&nbsp;<a href='"+pageURL+"?page="); 
				 * sb.append(i); 
				 * sb.append("'>");
				 * sb.append(i); 
				 * sb.append("</a>");
				 */
				sb.append(String.format("&nbsp;<a href='%s?page=%d'><span class='span_menu'>%d</span></a>", pageURL,i,i));
			}
		}// end for
		
		sb.append("&nbsp;|");
		
//-----�׷�������ó�� ���� ----------------------------------------------------------------------------------------------
		if(isNextPage){
			/*
			 * sb.append("<a href='"+pageURL+"?page="); 
			 * sb.append(endPage+1);
			 * sb.append("'>��</a>");
			 */
			
			sb.append(String.format("<a href='%s?page=%d'>��</a>", pageURL,endPage+1));
		}
		else
			sb.append("��");
//---------------------------------------------------------------------------------------------------------------------	    

		return sb.toString();
	}
	
	
	public static String getPaging(
		       String pageURL,
		       String search_filter,
		       int nowPage, 
		       int rowTotal,
		       int blockList, 
		       int blockPage){

		int totalPage /* ��ü�������� */, startPage /* ������������ȣ */, endPage /* ��������������ȣ */ ,firstPage , lastPage;

		
		boolean isPrevPage, isNextPage;
		StringBuffer sb; // ��� ��Ȳ�� �Ǵ��Ͽ� HTML�ڵ带 ������ ��

		isPrevPage = isNextPage = false;
		//�Էµ� ��ü �ڿ��� ���� ��ü ������ ���� ���Ѵ�..
		totalPage = rowTotal / blockList;
		if (rowTotal % blockList != 0)
			totalPage++;

		//���� �߸��� ����� ���������� ���Ͽ� ���� ������ ���� ��ü ������ ����
		//���� ��� ������ ���������� ���� ��ü ������ ������ ����
		if (nowPage > totalPage)
			nowPage = totalPage;

		//���� �������� ������ �������� ����.
		startPage = ((nowPage - 1) / blockPage) * blockPage + 1;
		endPage = startPage + blockPage - 1; //
		
		firstPage = 1;
		lastPage = totalPage;
		
		

		//������ ������ ���� ��ü������������ ũ�� ������������ ���� ����
		if (endPage > totalPage)
			endPage = totalPage;

		//�������������� ��ü���������� ���� ��� ���� ����¡�� ������ �� �ֵ���
		//boolean�� ������ ���� ����
		if (endPage < totalPage)
			isNextPage = true;
		//������������ ���� 1���� ������ ��������¡ ������ �� �ֵ��� ������
		if (startPage > 1)
			isPrevPage = true;

		//HTML�ڵ带 ������ StringBuffer����=>�ڵ����
		sb = new StringBuffer();

		//css�޴� �߰�
		sb.append("<link rel='stylesheet' href='../resources/css/page_menu.css'>");
//-----�׷�������ó�� ���� --------------------------------------------------------------------------------------------		
		if (isPrevPage) {

			sb.append(String.format("<a href='%s?page=%d&%s'>ù��°</a><a href='%s?page=%d&%s'>||����</a>"
					          , pageURL, firstPage,search_filter	, pageURL, startPage - 1,search_filter));
		} else
			sb.append("");

//------������ ��� ��� -------------------------------------------------------------------------------------------------
		sb.append("|");
		for (int i = startPage; i <= endPage; i++) {

			if (i == nowPage) { // ���� �ִ� ������
				sb.append("&nbsp;<b><font color='red'><span class='span_menu'>");
				sb.append(i);
				sb.append("</span></font></b>");
			} else {// ���� �������� �ƴϸ�
			
				sb.append(String.format("&nbsp;<a href='%s?page=%d&%s'><span class='span_menu'>%d</span></a>", 
						                             pageURL,   i,search_filter,               i));
			}
		} // end for

		sb.append("&nbsp;|");

//-----�׷�������ó�� ���� ----------------------------------------------------------------------------------------------
		if (isNextPage) {
			
			sb.append(String.format("<a href='%s?page=%d&%s'>����||</a><a href='%s?page=%d&%s'>������</a>"
								, pageURL, endPage + 1 , search_filter , pageURL, lastPage , search_filter));
		} else
			sb.append("");
//---------------------------------------------------------------------------------------------------------------------	    

		return sb.toString();
	}
	
	
	
	public static String getCommentPaging(int nowPage, int rowTotal, int blockList, int blockPage) {

		int totalPage /* ��ü�������� */, startPage /* ������������ȣ */, endPage; /* ��������������ȣ */

		boolean isPrevPage, isNextPage;
		StringBuffer sb; // ��� ��Ȳ�� �Ǵ��Ͽ� HTML�ڵ带 ������ ��

		isPrevPage = isNextPage = false;
		//�Էµ� ��ü �ڿ��� ���� ��ü ������ ���� ���Ѵ�..
		totalPage = rowTotal / blockList;
		if (rowTotal % blockList != 0)
			totalPage++;

		//���� �߸��� ����� ���������� ���Ͽ� ���� ������ ���� ��ü ������ ����
		//���� ��� ������ ���������� ���� ��ü ������ ������ ����
		if (nowPage > totalPage)
			nowPage = totalPage;

		//���� �������� ������ �������� ����.
		startPage = ((nowPage - 1) / blockPage) * blockPage + 1;
		endPage = startPage + blockPage - 1; //

		//������ ������ ���� ��ü������������ ũ�� ������������ ���� ����
		if (endPage > totalPage)
			endPage = totalPage;

		//�������������� ��ü���������� ���� ��� ���� ����¡�� ������ �� �ֵ���
		//boolean�� ������ ���� ����
		if (endPage < totalPage)
			isNextPage = true;
		//������������ ���� 1���� ������ ��������¡ ������ �� �ֵ��� ������
		if (startPage > 1)
			isPrevPage = true;

		//HTML�ڵ带 ������ StringBuffer����=>�ڵ����
		sb = new StringBuffer();

		//css�޴� �߰�
		sb.append("<link rel='stylesheet' href='../resources/css/page_menu.css'>");
//-----�׷�������ó�� ���� --------------------------------------------------------------------------------------------		
		if (isPrevPage) {

			sb.append(String.format("<a href='#c_menu' onclick='comment_list(%d);'>��</a>", startPage - 1));
		} else
			sb.append("��");

//------������ ��� ��� -------------------------------------------------------------------------------------------------
		sb.append("|");
		for (int i = startPage; i <= endPage; i++) {

			if (i == nowPage) { // ���� �ִ� ������
				sb.append("&nbsp;<b><font color='red'><span class='span_comment_menu'>");
				sb.append(i);
				sb.append("</span></font></b>");
			} else {// ���� �������� �ƴϸ�

				sb.append(String.format("&nbsp;<a href='#c_menu' onclick='comment_list(%d);'><span class='span_comment_menu'>%d</span></a>", 
						                                                         i,    						    i));
			}
		} // end for

		sb.append("&nbsp;|");

//-----�׷�������ó�� ���� ----------------------------------------------------------------------------------------------
		if (isNextPage) {
			
			sb.append(String.format("<a href='#c_menu' onclick='comment_list(%d);'>��</a>", endPage + 1));
		} else
			sb.append("��");
//---------------------------------------------------------------------------------------------------------------------	    

		return sb.toString();
	}
	
	
	
}