package com.gnss.fortunetelling

import android.util.Log
import com.gnss.fortunetelling.bean.ListBean
import com.gnss.fortunetelling.bean.ResultBean
import com.gnss.fortunetelling.bean.Stars
import com.google.gson.Gson
import java.io.IOException
import java.io.InputStream
import java.util.*

class JsonParser {

    companion object {
        lateinit var mData: ResultBean

        fun jsonParseWithSrc(): ResultBean {
            val str = readAssetsTxt("src.json")

            Log.d("测试 ", str!!)
            val data = Gson().fromJson<ResultBean>(str)
            Log.d("测试1",
                "返回结果 ${data.其他信息.性别} ${data.其他信息.五行局} ${data.其他信息.农历年} " + "${data.其他信息.农历日} ${data.其他信息.农历是否闰月}")
            mData = data
            return data
        }

        fun readAssetsTxt(fileName: String): String? {
            var inputStream: InputStream? = null
            try {
                inputStream = App.getContext().assets.open("$fileName")
                return convertStreamToString(inputStream) as String
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                inputStream?.close()
            }
            return "读取失败,请检查文件名称及文件是否存在!"
        }

        /**
         * input 流转换为字符串
         */
        fun convertStreamToString(input: InputStream): String? {
            var s: String? = null
            try {
                //格式转换
                val scanner = Scanner(input, "UTF-8").useDelimiter("\\A")
                if (scanner.hasNext()) {
                    s = scanner.next()
                }
                input.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
            return s
        }

        //读取十二宫位数据并加工处理以便展示出来
        //申
        fun loadShen(): ListBean {
            val elevenInfo = mData.十二宫信息
            val shen = elevenInfo.申
            val startList = shen.星列表
            val starSmall = shen.星庙旺
            val stars = listOf(Stars(startList.天伤, ""),
                Stars(startList.天刑, ""),
                Stars(startList.恩光, ""),
                Stars(startList.禄存, ""),
                Stars(startList.蜚廉, ""),
                Stars(startList.铃星, starSmall.铃星.庙旺))
            val bottomLeft = listOf(shen.生年博士, shen.生年将前, shen.生年岁前)
            val bottomRight = listOf("辛巳", shen.长生)
            val bottomCenter = listOf(shen.宫, shen.大限)
            val smallLimit = shen.小限.split(",")
            val limitSb = StringBuilder()
            for (index in smallLimit.indices) {
                when (index) {
                    2 -> {
                        limitSb.append("${smallLimit[index]}\n")
                    }
                    smallLimit.size - 1 -> {
                        limitSb.append(smallLimit[index])
                    }
                    else -> {
                        limitSb.append("${smallLimit[index]},")
                    }
                }
            }
            return ListBean(stars, bottomLeft, bottomRight, bottomCenter, limitSb.toString())
        }

        //酉
        fun loadYou(): ListBean {
            val elevenInfo = mData.十二宫信息
            val you = elevenInfo.酉
            val startList = you.星列表
            val starSmall = you.星庙旺
            val stars = listOf(Stars(startList.咸池, ""),
                Stars(startList.地劫, starSmall.地劫.庙旺),
                Stars(startList.天喜, ""),
                Stars(startList.天德, ""),
                Stars(startList.擎羊, starSmall.擎羊.庙旺))
            val bottomLeft = listOf(you.生年博士, you.生年将前, you.生年岁前)
            val bottomRight = listOf("辛巳", you.长生)
            val bottomCenter = listOf(you.宫, you.大限)
            val smallLimit = you.小限.split(",")
            val limitSb = StringBuilder()
            for (index in smallLimit.indices) {
                when (index) {
                    2 -> {
                        limitSb.append("${smallLimit[index]}\n")
                    }
                    smallLimit.size - 1 -> {
                        limitSb.append(smallLimit[index])
                    }
                    else -> {
                        limitSb.append("${smallLimit[index]},")
                    }
                }
            }
            return ListBean(stars, bottomLeft, bottomRight, bottomCenter, limitSb.toString())
        }

        /**
         * 戌
         */
        fun loadXu(): ListBean {
            val elevenInfo = mData.十二宫信息
            val xu = elevenInfo.戌
            val startList = xu.星列表
            val starSmall = xu.星庙旺
            val stars = listOf(Stars(startList.凤阁, ""),
                Stars(startList.天使, ""),
                Stars(startList.天同, starSmall.天同.庙旺),
                Stars(startList.天贵, ""),
                Stars(startList.寡宿, ""),
                Stars(startList.年解, ""))
            val bottomLeft = listOf(xu.生年博士, xu.生年将前, xu.生年岁前)
            val bottomRight = listOf("辛巳", xu.长生)
            val bottomCenter = listOf(xu.宫, xu.大限)
            val smallLimit = xu.小限.split(",")
            val limitSb = StringBuilder()
            for (index in smallLimit.indices) {
                when (index) {
                    2 -> {
                        limitSb.append("${smallLimit[index]}\n")
                    }
                    smallLimit.size - 1 -> {
                        limitSb.append(smallLimit[index])
                    }
                    else -> {
                        limitSb.append("${smallLimit[index]},")
                    }
                }
            }
            return ListBean(stars, bottomLeft, bottomRight, bottomCenter, limitSb.toString())
        }

        /**
         * 亥
         */
        fun loadHai(): ListBean {
            val elevenInfo = mData.十二宫信息
            val hai = elevenInfo.亥
            val startList = hai.星列表
            val starSmall = hai.星庙旺
            val stars = listOf(Stars(startList.右弼, starSmall.右弼.庙旺),
                Stars(startList.天官, ""),
                Stars(startList.天寿, ""),
                Stars(startList.天巫, ""),
                Stars(startList.武曲, starSmall.武曲.庙旺),
                Stars(startList.破军, starSmall.破军.庙旺))
            val bottomLeft = listOf(hai.生年博士, hai.生年将前, hai.生年岁前)
            val bottomRight = listOf("辛巳", hai.长生)
            val bottomCenter = listOf(hai.宫, hai.大限)
            val smallLimit = hai.小限.split(",")
            val limitSb = StringBuilder()
            for (index in smallLimit.indices) {
                when (index) {
                    2 -> {
                        limitSb.append("${smallLimit[index]}\n")
                    }
                    smallLimit.size - 1 -> {
                        limitSb.append(smallLimit[index])
                    }
                    else -> {
                        limitSb.append("${smallLimit[index]},")
                    }
                }
            }
            return ListBean(stars, bottomLeft, bottomRight, bottomCenter, limitSb.toString())
        }

        /**
         * 子
         */
        fun loadZi(): ListBean {
            val elevenInfo = mData.十二宫信息
            val zi = elevenInfo.子
            val startList = zi.星列表
            val starSmall = zi.星庙旺
            val stars = listOf(Stars(startList.三台, ""),
                Stars(startList.天姚, ""),
                Stars(startList.太阳, starSmall.太阳.庙旺),
                Stars(startList.封诰, ""),
                Stars(startList.文昌, starSmall.文昌.庙旺),
                Stars(startList.火星, starSmall.火星.庙旺))
            val bottomLeft = listOf(zi.生年博士, zi.生年将前, zi.生年岁前)
            val bottomRight = listOf("辛巳", zi.长生)
            val bottomCenter = listOf(zi.宫, zi.大限)
            val smallLimit = zi.小限.split(",")
            val limitSb = StringBuilder()
            for (index in smallLimit.indices) {
                when (index) {
                    2 -> {
                        limitSb.append("${smallLimit[index]}\n")
                    }
                    smallLimit.size - 1 -> {
                        limitSb.append(smallLimit[index])
                    }
                    else -> {
                        limitSb.append("${smallLimit[index]},")
                    }
                }
            }
            return ListBean(stars, bottomLeft, bottomRight, bottomCenter, limitSb.toString())
        }


        /**
         * 丑
         */
        fun loadChou(): ListBean {
            val elevenInfo = mData.十二宫信息
            val chou = elevenInfo.丑
            val startList = chou.星列表
            val starSmall = chou.星庙旺

            val stars = listOf(Stars(startList.地空, starSmall.地空.庙旺),
                Stars(startList.天府, starSmall.地空.庙旺),
                Stars(startList.天空, ""),
                Stars(startList.天魁, ""))
            val bottomLeft = listOf(chou.生年博士, chou.生年将前, chou.生年岁前)
            val bottomRight = listOf("辛巳", chou.长生)
            val bottomCenter = listOf(chou.宫, chou.大限)
            val smallLimit = chou.小限.split(",")
            val limitSb = StringBuilder()
            for (index in smallLimit.indices) {
                when (index) {
                    2 -> {
                        limitSb.append("${smallLimit[index]}\n")
                    }
                    smallLimit.size - 1 -> {
                        limitSb.append(smallLimit[index])
                    }
                    else -> {
                        limitSb.append("${smallLimit[index]},")
                    }
                }
            }
            return ListBean(stars, bottomLeft, bottomRight, bottomCenter, limitSb.toString())
        }


        /**
         * 寅
         */
        fun loadYin(): ListBean {
            val elevenInfo = mData.十二宫信息
            val yin = elevenInfo.寅
            val startList = yin.星列表
            val starSmall = yin.星庙旺

            val stars = listOf(Stars(startList.八座, ""),
                Stars(startList.天厨, ""),
                Stars(startList.天月, ""),
                Stars(startList.天机, starSmall.天机.庙旺),
                Stars(startList.天马, ""),
                Stars(startList.太阴, starSmall.太阴.庙旺),
                Stars(startList.孤辰, ""),
                Stars(startList.文曲, starSmall.文曲.庙旺))
            val bottomLeft = listOf(yin.生年博士, yin.生年将前, yin.生年岁前)
            val bottomRight = listOf("辛巳", yin.长生)
            val bottomCenter = listOf(yin.宫, yin.大限)
            val smallLimit = yin.小限.split(",")
            val limitSb = StringBuilder()
            for (index in smallLimit.indices) {
                when (index) {
                    2 -> {
                        limitSb.append("${smallLimit[index]}\n")
                    }
                    smallLimit.size - 1 -> {
                        limitSb.append(smallLimit[index])
                    }
                    else -> {
                        limitSb.append("${smallLimit[index]},")
                    }
                }
            }
            return ListBean(stars, bottomLeft, bottomRight, bottomCenter, limitSb.toString())
        }

        /**
         * 卯
         */
        fun loadMao(): ListBean {
            val elevenInfo = mData.十二宫信息
            val mao = elevenInfo.卯
            val startList = mao.星列表
            val starSmall = mao.星庙旺
            val stars = listOf(Stars(startList.天才, ""),
                Stars(startList.左辅, starSmall.左辅.庙旺),
                Stars(startList.紫微, starSmall.紫微.庙旺),
                Stars(startList.红鸾, ""),
                Stars(startList.贪狼, starSmall.贪狼.庙旺))
            val bottomLeft = listOf(mao.生年博士, mao.生年将前, mao.生年岁前)
            val bottomRight = listOf("辛巳", mao.长生)
            val bottomCenter = listOf(mao.宫, mao.大限)
            val smallLimit = mao.小限.split(",")
            val limitSb = StringBuilder()
            for (index in smallLimit.indices) {
                when (index) {
                    2 -> {
                        limitSb.append("${smallLimit[index]}\n")
                    }
                    smallLimit.size - 1 -> {
                        limitSb.append(smallLimit[index])
                    }
                    else -> {
                        limitSb.append("${smallLimit[index]},")
                    }
                }
            }
            return ListBean(stars, bottomLeft, bottomRight, bottomCenter, limitSb.toString())
        }

        /**
         * 辰
         */
        fun loadChen(): ListBean {
            val elevenInfo = mData.十二宫信息
            val chen = elevenInfo.辰
            val startList = chen.星列表
            val starSmall = chen.星庙旺

            val stars = listOf(Stars(startList.华盖, ""),
                Stars(startList.台辅, ""),
                Stars(startList.巨门, starSmall.巨门.庙旺),
                Stars(startList.旬空, ""),
                Stars(startList.阴煞, ""),
                Stars(startList.龙池, ""))
            val bottomLeft = listOf(chen.生年博士, chen.生年将前, chen.生年岁前)
            val bottomRight = listOf("辛巳", chen.长生)
            val bottomCenter = listOf(chen.宫, chen.大限)
            val smallLimit = chen.小限.split(",")
            val limitSb = StringBuilder()
            for (index in smallLimit.indices) {
                when (index) {
                    2 -> {
                        limitSb.append("${smallLimit[index]}\n")
                    }
                    smallLimit.size - 1 -> {
                        limitSb.append(smallLimit[index])
                    }
                    else -> {
                        limitSb.append("${smallLimit[index]},")
                    }
                }
            }
            return ListBean(stars, bottomLeft, bottomRight, bottomCenter, limitSb.toString())
        }

        /**
         * 巳
         */
        fun loadSi(): ListBean {
            val elevenInfo = mData.十二宫信息
            val si = elevenInfo.巳
            val startList = si.星列表
            val starSmall = si.星庙旺
            val stars = listOf(Stars(startList.副旬, ""),
                Stars(startList.劫煞, ""),
                Stars(startList.天相, starSmall.天相.庙旺),
                Stars(startList.破碎, ""))
            val bottomLeft = listOf(si.生年博士, si.生年将前, si.生年岁前)
            val bottomRight = listOf("辛巳", si.长生)
            val bottomCenter = listOf(si.宫, si.大限)
            val smallLimit = si.小限.split(",")
            val limitSb = StringBuilder()
            for (index in smallLimit.indices) {
                when (index) {
                    2 -> {
                        limitSb.append("${smallLimit[index]}\n")
                    }
                    smallLimit.size - 1 -> {
                        limitSb.append(smallLimit[index])
                    }
                    else -> {
                        limitSb.append("${smallLimit[index]},")
                    }
                }
            }
            return ListBean(stars, bottomLeft, bottomRight, bottomCenter, limitSb.toString())
        }


        /**
         * 午
         */
        fun loadWu(): ListBean {
            val elevenInfo = mData.十二宫信息
            val wu = elevenInfo.午
            val startList = wu.星列表
            val starSmall = wu.星庙旺

            val stars = listOf(Stars(startList.天哭, ""),
                Stars(startList.天梁, starSmall.天梁.庙旺),
                Stars(startList.天福, ""),
                Stars(startList.天虚, ""),
                Stars(startList.截空, ""),
                Stars(startList.解神, ""))
            val bottomLeft = listOf(wu.生年博士, wu.生年将前, wu.生年岁前)
            val bottomRight = listOf("辛巳", wu.长生)
            val bottomCenter = listOf(wu.宫, wu.大限)
            val smallLimit = wu.小限.split(",")
            val limitSb = StringBuilder()
            for (index in smallLimit.indices) {
                when (index) {
                    2 -> {
                        limitSb.append("${smallLimit[index]}\n")
                    }
                    smallLimit.size - 1 -> {
                        limitSb.append(smallLimit[index])
                    }
                    else -> {
                        limitSb.append("${smallLimit[index]},")
                    }
                }
            }
            return ListBean(stars, bottomLeft, bottomRight, bottomCenter, limitSb.toString())
        }

        /**
         * 未
         */
        fun loadWei(): ListBean {
            val elevenInfo = mData.十二宫信息
            val wei = elevenInfo.未
            val startList = wei.星列表
            val starSmall = wei.星庙旺

            val stars = listOf(Stars(startList.七杀, starSmall.七杀.庙旺),
                Stars(startList.副截, ""),
                Stars(startList.大耗, ""),
                Stars(startList.天钺, ""),
                Stars(startList.廉贞, starSmall.廉贞.庙旺),
                Stars(startList.陀罗, starSmall.陀罗.庙旺),
                Stars(startList.龙德, ""))
            val bottomLeft = listOf(wei.生年博士, wei.生年将前, wei.生年岁前)
            val bottomRight = listOf("辛巳", wei.长生)
            val bottomCenter = listOf(wei.宫, wei.大限)
            val smallLimit = wei.小限.split(",")
            val limitSb = StringBuilder()
            for (index in smallLimit.indices) {
                when (index) {
                    2 -> {
                        limitSb.append("${smallLimit[index]}\n")
                    }
                    smallLimit.size - 1 -> {
                        limitSb.append(smallLimit[index])
                    }
                    else -> {
                        limitSb.append("${smallLimit[index]},")
                    }
                }
            }
            return ListBean(stars, bottomLeft, bottomRight, bottomCenter, limitSb.toString())
        }
    }

}