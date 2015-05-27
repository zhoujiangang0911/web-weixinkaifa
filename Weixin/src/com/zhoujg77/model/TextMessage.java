package com.zhoujg77.model;

public class TextMessage  extends BaseMessage{
		
		private String Content;
		private String MsgId;
		
		
		public String getMsgId() {
			return MsgId;
		}
		public void setMsgId(String msgId) {
			MsgId = msgId;
		}
		
		public String getContent() {
			return Content;
		}
		public void setContent(String content) {
			Content = content;
		}
		public void setCreateTime(long time) {
			// TODO Auto-generated method stub
			
		}
		
		
		
}	
