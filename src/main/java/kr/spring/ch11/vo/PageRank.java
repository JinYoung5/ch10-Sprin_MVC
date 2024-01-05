package kr.spring.ch11.vo;

public class PageRank {
	private int rank;
	private String page;
	
	public PageRank() {} //자바빈에 Generate Constructor using Field를 생성하면 꼭 넣어야 됨
	
	public PageRank(int rank, String page) {
		super();
		this.rank = rank;
		this.page = page;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	@Override
	public String toString() {
		return "PageRank [rank=" + rank + ", page=" + page + "]";
	}
	
	
}
