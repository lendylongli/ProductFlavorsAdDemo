#这个一个关于怎样在Android Stuido里使用productFlavors的示例

示例中使用了多渠道打包，多渠道不同广告平台去了解productFlavors的用法

##main目录是一个module的基础，而其它productFlavors是根据这个基础去拓展不同的内容（可以是代码或者res资源或者依赖库）
注意，目录名与productFlavors声明的是一样，如果想要在不同的渠道使用不同的依赖库，比如channel_googleplay，<br>
则使用依赖库的方式为<br>
<code>
dependencies {<br>
    channel_googleplayCompile 'com.google.android.gms:play-services:5.0.89'<br>
}<br>
</code>

总的来说，productFlavors非常强大，供大家参考一下<br><br>

***

#关于作者
Leon Lee <br>
codeboy2013@gmail.com
<br><br>