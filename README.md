# Myglide

个人glide封装库

本工程copy于google的开源glide库，并对其进行了包装。

库的添加方法 ：   

    1、首先将本工程目录下的`glidesen`文件夹copy到你自己的工程目录下。    
    2、在你的工程目录先找到`settings.gadle`文件，添加：`include ':App',':glidesen'`。   
    3、再打开工程目录下的`App/build.gradle`文件，添加依赖工程，如下：`compile project(':glidesen')`。     
        PS：正确完成以上操作就可以在android目录下看到两个文件夹。分别为：`app`和`glidesen`。    
               没有出现就说明以上步骤有错。    
    4、检查`build.gradle（Module：app）`和`build.gradle（Module：glidesen）`两个文件下`minSdkVersion`和
      `targetSdkVersion`以及`compileSdkVersion`版本是否一致。否则会导致编译错误。
具体glide的使用方法可以参照此文章：

     [最全面解析Glide用法](www.jianshu.com/p/c3a5518b58b2 "Glide简书")

