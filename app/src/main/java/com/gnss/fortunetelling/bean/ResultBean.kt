package com.gnss.fortunetelling.bean

data class ResultBean(
    val 其他信息: 其他信息,
    val 十二宫信息: 十二宫信息
)



data class 其他信息(
    val 五行局: String,
    val 农历年: String,
    val 农历日: String,
    val 农历是否闰月: String,
    val 农历月: String,
    val 命主: String,
    val 年干: String,
    val 年支: String,
    val 性别: String,
    val 日干: String,
    val 日支: String,
    val 时干: String,
    val 时支: String,
    val 月干: String,
    val 月支: String,
    val 真太阳时: String,
    val 经度: String,
    val 身主: String,
    val 身宫: String,
    val 钟表时间: String
)

data class 十二宫信息(
    val 丑: 丑,
    val 亥: 亥,
    val 午: 午,
    val 卯: 卯,
    val 子: 子,
    val 寅: 寅,
    val 巳: 巳,
    val 戌: 戌,
    val 未: 未,
    val 申: 申,
    val 辰: 辰,
    val 酉: 酉
)

data class 丑(
    val 冲化: String,
    val 四化: 四化,
    val 大限: String,
    val 宫: String,
    val 宫干: String,
    val 小限: String,
    val 星列表: 星列表,
    val 星庙旺: 星庙旺,
    val 生年博士: String,
    val 生年将前: String,
    val 生年岁前: String,
    val 自化: String,
    val 长生: String
)

data class 亥(
    val 冲化: String,
    val 四化: 四化X,
    val 大限: String,
    val 宫: String,
    val 宫干: String,
    val 小限: String,
    val 星列表: 星列表X,
    val 星庙旺: 星庙旺X,
    val 生年博士: String,
    val 生年将前: String,
    val 生年岁前: String,
    val 自化: String,
    val 长生: String
)

data class 午(
    val 冲化: String,
    val 四化: 四化XX,
    val 大限: String,
    val 宫: String,
    val 宫干: String,
    val 小限: String,
    val 星列表: 星列表XX,
    val 星庙旺: 星庙旺XX,
    val 生年博士: String,
    val 生年将前: String,
    val 生年岁前: String,
    val 自化: 自化,
    val 长生: String
)

data class 卯(
    val 冲化: String,
    val 四化: 四化XXX,
    val 大限: String,
    val 宫: String,
    val 宫干: String,
    val 小限: String,
    val 星列表: 星列表XXX,
    val 星庙旺: 星庙旺XXX,
    val 生年博士: String,
    val 生年将前: String,
    val 生年岁前: String,
    val 自化: 自化X,
    val 长生: String
)

data class 子(
    val 冲化: String,
    val 四化: 四化XXXX,
    val 大限: String,
    val 宫: String,
    val 宫干: String,
    val 小限: String,
    val 星列表: 星列表XXXX,
    val 星庙旺: 星庙旺XXXX,
    val 生年博士: String,
    val 生年将前: String,
    val 生年岁前: String,
    val 自化: String,
    val 长生: String
)

data class 寅(
    val 冲化: String,
    val 四化: 四化XXXXX,
    val 大限: String,
    val 宫: String,
    val 宫干: String,
    val 小限: String,
    val 星列表: 星列表XXXXX,
    val 星庙旺: 星庙旺XXXXX,
    val 生年博士: String,
    val 生年将前: String,
    val 生年岁前: String,
    val 自化: 自化XX,
    val 长生: String
)

data class 巳(
    val 冲化: String,
    val 四化: 四化XXXXXX,
    val 大限: String,
    val 宫: String,
    val 宫干: String,
    val 小限: String,
    val 星列表: 星列表XXXXXX,
    val 星庙旺: 星庙旺XXXXXX,
    val 生年博士: String,
    val 生年将前: String,
    val 生年岁前: String,
    val 自化: String,
    val 长生: String
)

data class 戌(
    val 冲化: String,
    val 四化: 四化XXXXXXX,
    val 大限: String,
    val 宫: String,
    val 宫干: String,
    val 小限: String,
    val 星列表: 星列表XXXXXXX,
    val 星庙旺: 星庙旺XXXXXXX,
    val 生年博士: String,
    val 生年将前: String,
    val 生年岁前: String,
    val 自化: 自化XXX,
    val 长生: String
)

data class 未(
    val 冲化: String,
    val 四化: 四化XXXXXXXX,
    val 大限: String,
    val 宫: String,
    val 宫干: String,
    val 小限: String,
    val 星列表: 星列表XXXXXXXX,
    val 星庙旺: 星庙旺XXXXXXXX,
    val 生年博士: String,
    val 生年将前: String,
    val 生年岁前: String,
    val 自化: String,
    val 长生: String
)

data class 申(
    val 冲化: String,
    val 四化: 四化XXXXXXXXX,
    val 大限: String,
    val 宫: String,
    val 宫干: String,
    val 小限: String,
    val 星列表: 星列表XXXXXXXXX,
    val 星庙旺: 星庙旺XXXXXXXXX,
    val 生年博士: String,
    val 生年将前: String,
    val 生年岁前: String,
    val 自化: String,
    val 长生: String
)

data class 辰(
    val 冲化: 冲化,
    val 四化: 四化XXXXXXXXXX,
    val 大限: String,
    val 宫: String,
    val 宫干: String,
    val 小限: String,
    val 星列表: 星列表XXXXXXXXXX,
    val 星庙旺: 星庙旺XXXXXXXXXX,
    val 生年博士: String,
    val 生年将前: String,
    val 生年岁前: String,
    val 自化: String,
    val 长生: String
)

data class 酉(
    val 冲化: 冲化X,
    val 四化: 四化XXXXXXXXXXX,
    val 大限: String,
    val 宫: String,
    val 宫干: String,
    val 小限: String,
    val 星列表: 星列表XXXXXXXXXXX,
    val 星庙旺: 星庙旺XXXXXXXXXXX,
    val 生年博士: String,
    val 生年将前: String,
    val 生年岁前: String,
    val 自化: String,
    val 长生: String
)

data class 四化(
    val 忌: 忌,
    val 权: 权,
    val 禄: 禄,
    val 科: 科
)

data class 星列表(
    val 地空: String,
    val 天府: String,
    val 天空: String,
    val 天魁: String
)

data class 星庙旺(
    val 地空: 地空,
    val 天府: 天府
)

data class 忌(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 权(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 禄(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 科(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 地空(
    val 庙旺: String,
    val 级别值: String
)

data class 天府(
    val 庙旺: String,
    val 级别值: String
)

data class 四化X(
    val 忌: 忌X,
    val 权: 权X,
    val 禄: 禄X,
    val 科: 科X
)

data class 星列表X(
    val 右弼: String,
    val 天官: String,
    val 天寿: String,
    val 天巫: String,
    val 武曲: String,
    val 破军: String
)

data class 星庙旺X(
    val 右弼: 右弼,
    val 武曲: 武曲,
    val 破军: 破军
)

data class 忌X(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 权X(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 禄X(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 科X(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 右弼(
    val 庙旺: String,
    val 级别值: String
)

data class 武曲(
    val 庙旺: String,
    val 级别值: String
)

data class 破军(
    val 庙旺: String,
    val 级别值: String
)

data class 四化XX(
    val 忌: 忌XX,
    val 权: 权XX,
    val 禄: 禄XX,
    val 科: 科XX
)

data class 星列表XX(
    val 天哭: String,
    val 天梁: String,
    val 天福: String,
    val 天虚: String,
    val 截空: String,
    val 解神: String
)

data class 星庙旺XX(
    val 天梁: 天梁
)

data class 自化(
    val 禄: 禄XXX
)

data class 忌XX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 权XX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 禄XX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 科XX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 天梁(
    val 庙旺: String,
    val 级别值: String
)

data class 禄XXX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 四化XXX(
    val 忌: 忌XXX,
    val 权: 权XXX,
    val 禄: 禄XXXX,
    val 科: 科XXX
)

data class 星列表XXX(
    val 天才: String,
    val 左辅: String,
    val 紫微: String,
    val 红鸾: String,
    val 贪狼: String
)

data class 星庙旺XXX(
    val 左辅: 左辅,
    val 紫微: 紫微,
    val 贪狼: 贪狼
)

data class 自化X(
    val 权: 权XXXX
)

data class 忌XXX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 权XXX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 禄XXXX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 科XXX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 左辅(
    val 庙旺: String,
    val 级别值: String
)

data class 紫微(
    val 庙旺: String,
    val 级别值: String
)

data class 贪狼(
    val 庙旺: String,
    val 级别值: String
)

data class 权XXXX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 四化XXXX(
    val 忌: 忌XXXX,
    val 权: 权XXXXX,
    val 禄: 禄XXXXX,
    val 科: 科XXXX
)

data class 星列表XXXX(
    val 三台: String,
    val 天姚: String,
    val 太阳: String,
    val 封诰: String,
    val 文昌: String,
    val 火星: String
)

data class 星庙旺XXXX(
    val 太阳: 太阳,
    val 文昌: 文昌,
    val 火星: 火星
)

data class 忌XXXX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 权XXXXX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 禄XXXXX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 科XXXX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 太阳(
    val 庙旺: String,
    val 级别值: String
)

data class 文昌(
    val 庙旺: String,
    val 级别值: String
)

data class 火星(
    val 庙旺: String,
    val 级别值: String
)

data class 四化XXXXX(
    val 忌: 忌XXXXX,
    val 权: 权XXXXXX,
    val 禄: 禄XXXXXX,
    val 科: 科XXXXX
)

data class 星列表XXXXX(
    val 八座: String,
    val 天厨: String,
    val 天月: String,
    val 天机: String,
    val 天马: String,
    val 太阴: String,
    val 孤辰: String,
    val 文曲: String
)

data class 星庙旺XXXXX(
    val 天机: 天机,
    val 太阴: 太阴,
    val 文曲: 文曲
)

data class 自化XX(
    val 忌: 忌XXXXXX,
    val 权: 权XXXXXXX
)

data class 忌XXXXX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 权XXXXXX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 禄XXXXXX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 科XXXXX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 天机(
    val 庙旺: String,
    val 级别值: String
)

data class 太阴(
    val 庙旺: String,
    val 级别值: String
)

data class 文曲(
    val 庙旺: String,
    val 级别值: String
)

data class 忌XXXXXX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 权XXXXXXX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 四化XXXXXX(
    val 忌: 忌XXXXXXX,
    val 权: 权XXXXXXXX,
    val 禄: 禄XXXXXXX,
    val 科: 科XXXXXX
)

data class 星列表XXXXXX(
    val 副旬: String,
    val 劫煞: String,
    val 天相: String,
    val 破碎: String
)

data class 星庙旺XXXXXX(
    val 天相: 天相
)

data class 忌XXXXXXX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 权XXXXXXXX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 禄XXXXXXX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 科XXXXXX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 天相(
    val 庙旺: String,
    val 级别值: String
)

data class 四化XXXXXXX(
    val 忌: 忌XXXXXXXX,
    val 权: 权XXXXXXXXX,
    val 禄: 禄XXXXXXXX,
    val 科: 科XXXXXXX
)

data class 星列表XXXXXXX(
    val 凤阁: String,
    val 天使: String,
    val 天同: String,
    val 天贵: String,
    val 寡宿: String,
    val 年解: String
)

data class 星庙旺XXXXXXX(
    val 天同: 天同
)

data class 自化XXX(
    val 禄: 禄XXXXXXXXX
)

data class 忌XXXXXXXX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 权XXXXXXXXX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 禄XXXXXXXX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 科XXXXXXX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 天同(
    val 庙旺: String,
    val 级别值: String
)

data class 禄XXXXXXXXX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 四化XXXXXXXX(
    val 忌: 忌XXXXXXXXX,
    val 权: 权XXXXXXXXXX,
    val 禄: 禄XXXXXXXXXX,
    val 科: 科XXXXXXXX
)

data class 星列表XXXXXXXX(
    val 七杀: String,
    val 副截: String,
    val 大耗: String,
    val 天钺: String,
    val 廉贞: String,
    val 陀罗: String,
    val 龙德: String
)

data class 星庙旺XXXXXXXX(
    val 七杀: 七杀,
    val 廉贞: 廉贞,
    val 陀罗: 陀罗
)

data class 忌XXXXXXXXX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 权XXXXXXXXXX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 禄XXXXXXXXXX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 科XXXXXXXX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 七杀(
    val 庙旺: String,
    val 级别值: String
)

data class 廉贞(
    val 庙旺: String,
    val 级别值: String
)

data class 陀罗(
    val 庙旺: String,
    val 级别值: String
)

data class 四化XXXXXXXXX(
    val 忌: 忌XXXXXXXXXX,
    val 权: 权XXXXXXXXXXX,
    val 禄: 禄XXXXXXXXXXX,
    val 科: 科XXXXXXXXX
)

data class 星列表XXXXXXXXX(
    val 天伤: String,
    val 天刑: String,
    val 恩光: String,
    val 禄存: String,
    val 蜚廉: String,
    val 铃星: String
)

data class 星庙旺XXXXXXXXX(
    val 铃星: 铃星
)

data class 忌XXXXXXXXXX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 权XXXXXXXXXXX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 禄XXXXXXXXXXX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 科XXXXXXXXX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 铃星(
    val 庙旺: String,
    val 级别值: String
)

data class 冲化(
    val 忌: 忌XXXXXXXXXXX
)

data class 四化XXXXXXXXXX(
    val 忌: 忌XXXXXXXXXXXX,
    val 权: 权XXXXXXXXXXXX,
    val 禄: 禄XXXXXXXXXXXX,
    val 科: 科XXXXXXXXXX
)

data class 星列表XXXXXXXXXX(
    val 华盖: String,
    val 台辅: String,
    val 巨门: String,
    val 旬空: String,
    val 阴煞: String,
    val 龙池: String
)

data class 星庙旺XXXXXXXXXX(
    val 巨门: 巨门
)

data class 忌XXXXXXXXXXX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 忌XXXXXXXXXXXX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 权XXXXXXXXXXXX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 禄XXXXXXXXXXXX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 科XXXXXXXXXX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 巨门(
    val 庙旺: String,
    val 级别值: String
)

data class 冲化X(
    val 科: 科XXXXXXXXXXX
)

data class 四化XXXXXXXXXXX(
    val 忌: 忌XXXXXXXXXXXXX,
    val 权: 权XXXXXXXXXXXXX,
    val 禄: 禄XXXXXXXXXXXXX,
    val 科: 科XXXXXXXXXXXX
)

data class 星列表XXXXXXXXXXX(
    val 咸池: String,
    val 地劫: String,
    val 天喜: String,
    val 天德: String,
    val 擎羊: String
)

data class 星庙旺XXXXXXXXXXX(
    val 地劫: 地劫,
    val 擎羊: 擎羊
)

data class 科XXXXXXXXXXX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 忌XXXXXXXXXXXXX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 权XXXXXXXXXXXXX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 禄XXXXXXXXXXXXX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 科XXXXXXXXXXXX(
    val 力度: String,
    val 支: String,
    val 星: String
)

data class 地劫(
    val 庙旺: String,
    val 级别值: String
)

data class 擎羊(
    val 庙旺: String,
    val 级别值: String
)