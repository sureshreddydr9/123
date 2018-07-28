class SpilitMessage
{
	public String content="";
	
	public int mesLength(String msgText)
	{
		this.content = msgText;
		int delimiterCount=0;
		char[] proResult=content.toCharArray();
		
		for (int i = 0; i < proResult.length; i++)
		{
			
			if(proResult[i]=='*')
			{
				delimiterCount++;
			}
		}
		System.out.println("Count------------------ : " + delimiterCount);
		return delimiterCount;
	}
}