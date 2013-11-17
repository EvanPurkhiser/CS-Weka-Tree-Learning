TreeLearning.class: TreeLearning.java weka.jar
	CLASSPATH=$CLASSPATH:weka.jar javac TreeLearning.java

weka.jar:
	wget -O /tmp/weka-3-6-10.zip "http://sourceforge.net/projects/weka/files/weka-3-6/3.6.10/weka-3-6-10.zip/download"
	unzip -p /tmp/weka-3-6-10.zip weka-3-6-10/weka.jar > weka.jar

clean:
	rm -f TreeLearning.class weka.jar
