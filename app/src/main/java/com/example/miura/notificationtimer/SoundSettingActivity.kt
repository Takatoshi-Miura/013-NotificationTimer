package com.example.miura.notificationtimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_sound_setting.*

class SoundSettingActivity : AppCompatActivity() {

    private lateinit var mAdapter: SimpleExpandableListAdapter

    companion object {
        const val KEY_PARENT = "FOLDER"
        const val KEY_CHILD  = "CATEGORY"
    }


    // ライフサイクルメソッド
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sound_setting)

        // 音声設定リストをロード
        loadFolders()
    }


    // 音声設定リストをロードするメソッド
    private fun loadFolders() {
        // 宣言
        val folders = mutableListOf<Map<String, String>>()
        val categoriesOfFolder = mutableListOf<MutableList<Map<String, String>>>()

        // タイトルを格納
        var folderTitleList    = arrayOf("一括設定","終了時","経過時間通知","残り時間通知","その他")
        var categoryTitleList0 = arrayOf("マナーモード")
        var categoryTitleList1 = arrayOf("終了時")
        var categoryTitleList2 = arrayOf("5分経過","10分経過","15分経過","20分経過","25分経過",
                                         "30分経過","35分経過","40分経過","45分経過","50分経過")
        var categoryTitleList3 = arrayOf("残り30秒","残り1分","残り3分","残り5分")
        var categoryTitleList4 = arrayOf("タイマー起動時")

        // リストの項目を作成
        for (i in 0..4) {
            // セクションタイトルを作成
            val category = mapOf(KEY_PARENT to folderTitleList[i])
            folders.add(category)

            // セクションの項目を作成
            val categories = mutableListOf<Map<String, String>>()
            when (i) {
                0 -> for (j in 0..categoryTitleList0.size - 1) {
                        val title = mapOf(KEY_CHILD to categoryTitleList0[j])
                        categories.add(title)
                     }
                1 -> for (j in 0..categoryTitleList1.size - 1) {
                        val title = mapOf(KEY_CHILD to categoryTitleList1[j])
                        categories.add(title)
                     }
                2 -> for (j in 0..categoryTitleList2.size - 1) {
                        val title = mapOf(KEY_CHILD to categoryTitleList2[j])
                        categories.add(title)
                     }
                3 -> for (j in 0..categoryTitleList3.size - 1) {
                        val title = mapOf(KEY_CHILD to categoryTitleList3[j])
                        categories.add(title)
                     }
                4 -> for (j in 0..categoryTitleList4.size - 1) {
                        val title = mapOf(KEY_CHILD to categoryTitleList4[j])
                        categories.add(title)
                     }
            }
            categoriesOfFolder.add(categories)
        }

        // アダプターに上記で作成した項目を反映
        mAdapter = SimpleExpandableListAdapter(
            this,
            folders,
            android.R.layout.simple_expandable_list_item_1,
            arrayOf(KEY_PARENT),
            intArrayOf(android.R.id.text1, android.R.id.text2),
            categoriesOfFolder,
            android.R.layout.simple_expandable_list_item_1,
            arrayOf(KEY_CHILD),
            intArrayOf(android.R.id.text1, android.R.id.text2)
        )

        // リストビューにアダプターを反映
        val listView = (findViewById(R.id.expandable_listview) as ExpandableListView)
        listView.setAdapter(mAdapter)
    }

}
