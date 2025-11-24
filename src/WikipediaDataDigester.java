public class WikipediaDataDigester {
    public static void main(String[] args) {
        String[] listFromWikipedia = {"1\tH\tHydrogen\t[k]\t1\t1\ts-block\t1.0080\t0.00008988\t14.01\t20.28\t14.304\t2.20\t1400\tprimordial\tgas\n",
                "2\tHe\tHelium\t[l]\t18\t1\ts-block\t4.0026\t0.0001785\t–[m]\t4.22\t5.193\t–\t0.008\tprimordial\tgas\n",
                "3\tLi\tLithium\t[n]\t1\t2\ts-block\t6.94\t0.534\t453.69\t1560\t3.582\t0.98\t20\tprimordial\tsolid\n",
                "4\tBe\tBeryllium\t[o]\t2\t2\ts-block\t9.0122\t1.85\t1560\t2742\t1.825\t1.57\t2.8\tprimordial\tsolid\n",
                "5\tB\tBoron\t[p]\t13\t2\tp-block\t10.81\t2.34\t2349\t4200\t1.026\t2.04\t10\tprimordial\tsolid\n",
                "6\tC\tCarbon\t[q]\t14\t2\tp-block\t12.011\t2.267\t>4000\t4300\t0.709\t2.55\t200\tprimordial\tsolid\n",
                "7\tN\tNitrogen\t[r]\t15\t2\tp-block\t14.007\t0.0012506\t63.15\t77.36\t1.04\t3.04\t19\tprimordial\tgas\n",
                "8\tO\tOxygen\t[s]\t16\t2\tp-block\t15.999\t0.001429\t54.36\t90.20\t0.918\t3.44\t461000\tprimordial\tgas\n",
                "9\tF\tFluorine\t[t]\t17\t2\tp-block\t18.998\t0.001696\t53.53\t85.03\t0.824\t3.98\t585\tprimordial\tgas\n",
                "10\tNe\tNeon\t[u]\t18\t2\tp-block\t20.180\t0.0009002\t24.56\t27.07\t1.03\t–\t0.005\tprimordial\tgas\n",
                "11\tNa\tSodium\t[v]\t1\t3\ts-block\t22.990\t0.968\t370.87\t1156\t1.228\t0.93\t23600\tprimordial\tsolid\n",
                "12\tMg\tMagnesium\t[w]\t2\t3\ts-block\t24.305\t1.738\t923\t1363\t1.023\t1.31\t23300\tprimordial\tsolid\n",
                "13\tAl\tAluminium\t[x]\t13\t3\tp-block\t26.982\t2.70\t933.47\t2792\t0.897\t1.61\t82300\tprimordial\tsolid\n",
                "14\tSi\tSilicon\t[y]\t14\t3\tp-block\t28.085\t2.3290\t1687\t3538\t0.705\t1.9\t282000\tprimordial\tsolid\n",
                "15\tP\tPhosphorus\t[z]\t15\t3\tp-block\t30.974\t1.823\t317.30\t550\t0.769\t2.19\t1050\tprimordial\tsolid\n",
                "16\tS\tSulfur\t[aa]\t16\t3\tp-block\t32.06\t2.07\t388.36\t717.87\t0.71\t2.58\t350\tprimordial\tsolid\n",
                "17\tCl\tChlorine\t[ab]\t17\t3\tp-block\t35.45\t0.0032\t171.6\t239.11\t0.479\t3.16\t145\tprimordial\tgas\n",
                "18\tAr\tArgon\t[ac]\t18\t3\tp-block\t39.95\t0.001784\t83.80\t87.30\t0.52\t–\t3.5\tprimordial\tgas\n",
                "19\tK\tPotassium\t[ad]\t1\t4\ts-block\t39.098\t0.89\t336.53\t1032\t0.757\t0.82\t20900\tprimordial\tsolid\n",
                "20\tCa\tCalcium\t[ae]\t2\t4\ts-block\t40.078\t1.55\t1115\t1757\t0.647\t1.00\t41500\tprimordial\tsolid\n",
                "21\tSc\tScandium\t[af]\t3\t4\td-block\t44.956\t2.985\t1814\t3109\t0.568\t1.36\t22\tprimordial\tsolid\n",
                "22\tTi\tTitanium\t[ag]\t4\t4\td-block\t47.867\t4.506\t1941\t3560\t0.523\t1.54\t5650\tprimordial\tsolid\n",
                "23\tV\tVanadium\t[ah]\t5\t4\td-block\t50.942\t6.11\t2183\t3680\t0.489\t1.63\t120\tprimordial\tsolid\n",
                "24\tCr\tChromium\t[ai]\t6\t4\td-block\t51.996\t7.15\t2180\t2944\t0.449\t1.66\t102\tprimordial\tsolid\n",
                "25\tMn\tManganese\t[aj]\t7\t4\td-block\t54.938\t7.21\t1519\t2334\t0.479\t1.55\t950\tprimordial\tsolid\n",
                "26\tFe\tIron\t[ak]\t8\t4\td-block\t55.845\t7.874\t1811\t3134\t0.449\t1.83\t56300\tprimordial\tsolid\n",
                "27\tCo\tCobalt\t[al]\t9\t4\td-block\t58.933\t8.90\t1768\t3200\t0.421\t1.88\t25\tprimordial\tsolid\n",
                "28\tNi\tNickel\t[am]\t10\t4\td-block\t58.693\t8.908\t1728\t3186\t0.444\t1.91\t84\tprimordial\tsolid\n",
                "29\tCu\tCopper\t[an]\t11\t4\td-block\t63.546\t8.96\t1357.77\t2835\t0.385\t1.90\t60\tprimordial\tsolid\n",
                "30\tZn\tZinc\t[ao]\t12\t4\td-block\t65.38\t7.14\t692.88\t1180\t0.388\t1.65\t70\tprimordial\tsolid\n",
                "31\tGa\tGallium\t[ap]\t13\t4\tp-block\t69.723\t5.91\t302.9146\t2673\t0.371\t1.81\t19\tprimordial\tsolid\n",
                "32\tGe\tGermanium\t[aq]\t14\t4\tp-block\t72.630\t5.323\t1211.40\t3106\t0.32\t2.01\t1.5\tprimordial\tsolid\n",
                "33\tAs\tArsenic\t[ar]\t15\t4\tp-block\t74.922\t5.727\t1090[as]\t887\t0.329\t2.18\t1.8\tprimordial\tsolid\n",
                "34\tSe\tSelenium\t[at]\t16\t4\tp-block\t78.971\t4.81\t453\t958\t0.321\t2.55\t0.05\tprimordial\tsolid\n",
                "35\tBr\tBromine\t[au]\t17\t4\tp-block\t79.904\t3.1028\t265.8\t332.0\t0.474\t2.96\t2.4\tprimordial\tliquid\n",
                "36\tKr\tKrypton\t[av]\t18\t4\tp-block\t83.798\t0.003749\t115.79\t119.93\t0.248\t3.00\t1×10−4\tprimordial\tgas\n",
                "37\tRb\tRubidium\t[aw]\t1\t5\ts-block\t85.468\t1.532\t312.46\t961\t0.363\t0.82\t90\tprimordial\tsolid\n",
                "38\tSr\tStrontium\t[ax]\t2\t5\ts-block\t87.62\t2.64\t1050\t1655\t0.301\t0.95\t370\tprimordial\tsolid\n",
                "39\tY\tYttrium\t[ay]\t3\t5\td-block\t88.906\t4.472\t1799\t3609\t0.298\t1.22\t33\tprimordial\tsolid\n",
                "40\tZr\tZirconium\t[az]\t4\t5\td-block\t91.224\t6.52\t2128\t4682\t0.278\t1.33\t165\tprimordial\tsolid\n",
                "41\tNb\tNiobium\t[ba]\t5\t5\td-block\t92.906\t8.57\t2750\t5017\t0.265\t1.6\t20\tprimordial\tsolid\n",
                "42\tMo\tMolybdenum\t[bb]\t6\t5\td-block\t95.95\t10.28\t2896\t4912\t0.251\t2.16\t1.2\tprimordial\tsolid\n",
                "43\tTc\tTechnetium\t[bc]\t7\t5\td-block\t[97]\t11\t2430\t4538\t–\t1.9\t~ 3×10−9\tfrom decay\tsolid\n",
                "44\tRu\tRuthenium\t[bd]\t8\t5\td-block\t101.07\t12.45\t2607\t4423\t0.238\t2.2\t0.001\tprimordial\tsolid\n",
                "45\tRh\tRhodium\t[be]\t9\t5\td-block\t102.91\t12.41\t2237\t3968\t0.243\t2.28\t0.001\tprimordial\tsolid\n",
                "46\tPd\tPalladium\t[bf]\t10\t5\td-block\t106.42\t12.023\t1828.05\t3236\t0.244\t2.20\t0.015\tprimordial\tsolid\n",
                "47\tAg\tSilver\t[bg]\t11\t5\td-block\t107.87\t10.49\t1234.93\t2435\t0.235\t1.93\t0.075\tprimordial\tsolid\n",
                "48\tCd\tCadmium\t[bh]\t12\t5\td-block\t112.41\t8.65\t594.22\t1040\t0.232\t1.69\t0.159\tprimordial\tsolid\n",
                "49\tIn\tIndium\t[bi]\t13\t5\tp-block\t114.82\t7.31\t429.75\t2345\t0.233\t1.78\t0.25\tprimordial\tsolid\n",
                "50\tSn\tTin\t[bj]\t14\t5\tp-block\t118.71\t7.265\t505.08\t2875\t0.228\t1.96\t2.3\tprimordial\tsolid\n",
                "51\tSb\tAntimony\t[bk]\t15\t5\tp-block\t121.76\t6.697\t903.78\t1860\t0.207\t2.05\t0.2\tprimordial\tsolid\n",
                "52\tTe\tTellurium\t[bl]\t16\t5\tp-block\t127.60\t6.24\t722.66\t1261\t0.202\t2.1\t0.001\tprimordial\tsolid\n",
                "53\tI\tIodine\t[bm]\t17\t5\tp-block\t126.90\t4.933\t386.85\t457.4\t0.214\t2.66\t0.45\tprimordial\tsolid\n",
                "54\tXe\tXenon\t[bn]\t18\t5\tp-block\t131.29\t0.005894\t161.4\t165.03\t0.158\t2.60\t3×10−5\tprimordial\tgas\n",
                "55\tCs\tCaesium\t[bo]\t1\t6\ts-block\t132.91\t1.93\t301.59\t944\t0.242\t0.79\t3\tprimordial\tsolid\n",
                "56\tBa\tBarium\t[bp]\t2\t6\ts-block\t137.33\t3.51\t1000\t2170\t0.204\t0.89\t425\tprimordial\tsolid\n",
                "57\tLa\tLanthanum\t[bq]\tf-block groups\t6\tf-block\t138.91\t6.162\t1193\t3737\t0.195\t1.1\t39\tprimordial\tsolid\n",
                "58\tCe\tCerium\t[br]\tf-block groups\t6\tf-block\t140.12\t6.770\t1068\t3716\t0.192\t1.12\t66.5\tprimordial\tsolid\n",
                "59\tPr\tPraseodymium\t[bs]\tf-block groups\t6\tf-block\t140.91\t6.77\t1208\t3793\t0.193\t1.13\t9.2\tprimordial\tsolid\n",
                "60\tNd\tNeodymium\t[bt]\tf-block groups\t6\tf-block\t144.24\t7.01\t1297\t3347\t0.19\t1.14\t41.5\tprimordial\tsolid\n",
                "61\tPm\tPromethium\t[bu]\tf-block groups\t6\tf-block\t[145]\t7.26\t1315\t3273\t–\t1.13\t2×10−19\tfrom decay\tsolid\n",
                "62\tSm\tSamarium\t[bv]\tf-block groups\t6\tf-block\t150.36\t7.52\t1345\t2067\t0.197\t1.17\t7.05\tprimordial\tsolid\n",
                "63\tEu\tEuropium\t[bw]\tf-block groups\t6\tf-block\t151.96\t5.244\t1099\t1802\t0.182\t1.2\t2\tprimordial\tsolid\n",
                "64\tGd\tGadolinium\t[bx]\tf-block groups\t6\tf-block\t157.25\t7.90\t1585\t3546\t0.236\t1.2\t6.2\tprimordial\tsolid\n",
                "65\tTb\tTerbium\t[by]\tf-block groups\t6\tf-block\t158.93\t8.23\t1629\t3503\t0.182\t1.2\t1.2\tprimordial\tsolid\n",
                "66\tDy\tDysprosium\t[bz]\tf-block groups\t6\tf-block\t162.50\t8.540\t1680\t2840\t0.17\t1.22\t5.2\tprimordial\tsolid\n",
                "67\tHo\tHolmium\t[ca]\tf-block groups\t6\tf-block\t164.93\t8.79\t1734\t2993\t0.165\t1.23\t1.3\tprimordial\tsolid\n",
                "68\tEr\tErbium\t[cb]\tf-block groups\t6\tf-block\t167.26\t9.066\t1802\t3141\t0.168\t1.24\t3.5\tprimordial\tsolid\n",
                "69\tTm\tThulium\t[cc]\tf-block groups\t6\tf-block\t168.93\t9.32\t1818\t2223\t0.16\t1.25\t0.52\tprimordial\tsolid\n",
                "70\tYb\tYtterbium\t[cd]\tf-block groups\t6\tf-block\t173.05\t6.90\t1097\t1469\t0.155\t1.1\t3.2\tprimordial\tsolid\n",
                "71\tLu\tLutetium\t[ce]\t3\t6\td-block\t174.97\t9.841\t1925\t3675\t0.154\t1.27\t0.8\tprimordial\tsolid\n",
                "72\tHf\tHafnium\t[cf]\t4\t6\td-block\t178.49\t13.31\t2506\t4876\t0.144\t1.3\t3\tprimordial\tsolid\n",
                "73\tTa\tTantalum\t[cg]\t5\t6\td-block\t180.95\t16.69\t3290\t5731\t0.14\t1.5\t2\tprimordial\tsolid\n",
                "74\tW\tTungsten\t[ch]\t6\t6\td-block\t183.84\t19.25\t3695\t6203\t0.132\t2.36\t1.3\tprimordial\tsolid\n",
                "75\tRe\tRhenium\t[ci]\t7\t6\td-block\t186.21\t21.02\t3459\t5869\t0.137\t1.9\t7×10−4\tprimordial\tsolid\n",
                "76\tOs\tOsmium\t[cj]\t8\t6\td-block\t190.23\t22.59\t3306\t5285\t0.13\t2.2\t0.002\tprimordial\tsolid\n",
                "77\tIr\tIridium\t[ck]\t9\t6\td-block\t192.22\t22.56\t2719\t4701\t0.131\t2.20\t0.001\tprimordial\tsolid\n",
                "78\tPt\tPlatinum\t[cl]\t10\t6\td-block\t195.08\t21.45\t2041.4\t4098\t0.133\t2.28\t0.005\tprimordial\tsolid\n",
                "79\tAu\tGold\t[cm]\t11\t6\td-block\t196.97\t19.3\t1337.33\t3129\t0.129\t2.54\t0.004\tprimordial\tsolid\n",
                "80\tHg\tMercury\t[cn]\t12\t6\td-block\t200.59\t13.534\t234.43\t629.88\t0.14\t2.00\t0.085\tprimordial\tliquid\n",
                "81\tTl\tThallium\t[co]\t13\t6\tp-block\t204.38\t11.85\t577\t1746\t0.129\t1.62\t0.85\tprimordial\tsolid\n",
                "82\tPb\tLead\t[cp]\t14\t6\tp-block\t207.2\t11.34\t600.61\t2022\t0.129\t1.87 (2+)2.33 (4+)\t14\tprimordial\tsolid\n",
                "83\tBi\tBismuth\t[cq]\t15\t6\tp-block\t208.98\t9.78\t544.7\t1837\t0.122\t2.02\t0.009\tprimordial\tsolid\n",
                "84\tPo\tPolonium\t[cr]\t16\t6\tp-block\t[209][a]\t9.196\t527\t1235\t–\t2.0\t2×10−10\tfrom decay\tsolid\n",
                "85\tAt\tAstatine\t[cs]\t17\t6\tp-block\t[210]\t(8.91–8.95)\t575\t610\t–\t2.2\t3×10−20\tfrom decay\tunknown phase\n",
                "86\tRn\tRadon\t[ct]\t18\t6\tp-block\t[222]\t0.00973\t202\t211.3\t0.094\t2.2\t4×10−13\tfrom decay\tgas\n",
                "87\tFr\tFrancium\t[cu]\t1\t7\ts-block\t[223]\t(2.48)\t281\t890\t–\t>0.79[5]\t~ 1×10−18\tfrom decay\tunknown phase\n",
                "88\tRa\tRadium\t[cv]\t2\t7\ts-block\t[226]\t5.5\t973\t2010\t0.094\t0.9\t9×10−7\tfrom decay\tsolid\n",
                "89\tAc\tActinium\t[cw]\tf-block groups\t7\tf-block\t[227]\t10\t1323\t3471\t0.12\t1.1\t5.5×10−10\tfrom decay\tsolid\n",
                "90\tTh\tThorium\t[cx]\tf-block groups\t7\tf-block\t232.04\t11.7\t2115\t5061\t0.113\t1.3\t9.6\tprimordial\tsolid\n",
                "91\tPa\tProtactinium\t[cy]\tf-block groups\t7\tf-block\t231.04\t15.37\t1841\t4300\t–\t1.5\t1.4×10−6\tfrom decay\tsolid\n",
                "92\tU\tUranium\t[cz]\tf-block groups\t7\tf-block\t238.03\t19.1\t1405.3\t4404\t0.116\t1.38\t2.7\tprimordial\tsolid\n",
                "93\tNp\tNeptunium\t[da]\tf-block groups\t7\tf-block\t[237]\t20.45\t917\t4273\t–\t1.36\t≤ 3×10−12\tfrom decay\tsolid\n",
                "94\tPu\tPlutonium\t[db]\tf-block groups\t7\tf-block\t[244]\t19.85\t912.5\t3501\t–\t1.28\t≤ 3×10−11\tfrom decay\tsolid\n",
                "95\tAm\tAmericium\t[dc]\tf-block groups\t7\tf-block\t[243]\t12\t1449\t2880\t–\t1.13\t–\tsynthetic\tsolid\n",
                "96\tCm\tCurium\t[dd]\tf-block groups\t7\tf-block\t[247]\t13.51\t1613\t3383\t–\t1.28\t–\tsynthetic\tsolid\n",
                "97\tBk\tBerkelium\t[de]\tf-block groups\t7\tf-block\t[247]\t14.78\t1259\t2900\t–\t1.3\t–\tsynthetic\tsolid\n",
                "98\tCf\tCalifornium\t[df]\tf-block groups\t7\tf-block\t[251]\t15.1\t1173\t(1743)[b]\t–\t1.3\t–\tsynthetic\tsolid\n",
                "99\tEs\tEinsteinium\t[dg]\tf-block groups\t7\tf-block\t[252]\t8.84\t1133\t(1269)\t–\t1.3\t–\tsynthetic\tsolid\n",
                "100\tFm\tFermium\t[dh]\tf-block groups\t7\tf-block\t[257]\t(9.7)[b]\t(1125)[6](1800)[7]\t–\t–\t1.3\t–\tsynthetic\tunknown phase\n",
                "101\tMd\tMendelevium\t[di]\tf-block groups\t7\tf-block\t[258]\t(10.3)\t(1100)\t–\t–\t1.3\t–\tsynthetic\tunknown phase\n",
                "102\tNo\tNobelium\t[dj]\tf-block groups\t7\tf-block\t[259]\t(9.9)\t(1100)\t–\t–\t1.3\t–\tsynthetic\tunknown phase\n",
                "103\tLr\tLawrencium\t[dk]\t3\t7\td-block\t[266]\t(14.4)\t(1900)\t–\t–\t1.3\t–\tsynthetic\tunknown phase\n",
                "104\tRf\tRutherfordium\t[dl]\t4\t7\td-block\t[267]\t(17)\t(2400)\t(5800)\t–\t–\t–\tsynthetic\tunknown phase\n",
                "105\tDb\tDubnium\t[dm]\t5\t7\td-block\t[268]\t(21.6)\t–\t–\t–\t–\t–\tsynthetic\tunknown phase\n",
                "106\tSg\tSeaborgium\t[dn]\t6\t7\td-block\t[267]\t(23–24)\t–\t–\t–\t–\t–\tsynthetic\tunknown phase\n",
                "107\tBh\tBohrium\t[do]\t7\t7\td-block\t[270]\t(26–27)\t–\t–\t–\t–\t–\tsynthetic\tunknown phase\n",
                "108\tHs\tHassium\t[dp]\t8\t7\td-block\t[271]\t(27–29)\t–\t–\t–\t–\t–\tsynthetic\tunknown phase\n",
                "109\tMt\tMeitnerium\t[dq]\t9\t7\td-block\t[278]\t(27–28)\t–\t–\t–\t–\t–\tsynthetic\tunknown phase\n",
                "110\tDs\tDarmstadtium\t[dr]\t10\t7\td-block\t[281]\t(26–27)\t–\t–\t–\t–\t–\tsynthetic\tunknown phase\n",
                "111\tRg\tRoentgenium\t[ds]\t11\t7\td-block\t[282]\t(22–24)\t–\t–\t–\t–\t–\tsynthetic\tunknown phase\n",
                "112\tCn\tCopernicium\t[dt]\t12\t7\td-block\t[285]\t(14.0)\t(283±11)\t(340±10)[b]\t–\t–\t–\tsynthetic\tunknown phase\n",
                "113\tNh\tNihonium\t[du]\t13\t7\tp-block\t[286]\t(16)\t(700)\t(1400)\t–\t–\t–\tsynthetic\tunknown phase\n",
                "114\tFl\tFlerovium\t[dv]\t14\t7\tp-block\t[289]\t(11.4±0.3)\t(284±50)[b]\t–\t–\t–\t–\tsynthetic\tunknown phase\n",
                "115\tMc\tMoscovium\t[dw]\t15\t7\tp-block\t[290]\t(13.5)\t(700)\t(1400)\t–\t–\t–\tsynthetic\tunknown phase\n",
                "116\tLv\tLivermorium\t[dx]\t16\t7\tp-block\t[293]\t(12.9)\t(700)\t(1100)\t–\t–\t–\tsynthetic\tunknown phase\n",
                "117\tTs\tTennessine\t[dy]\t17\t7\tp-block\t[294]\t(7.1–7.3)\t(700)\t(883)\t–\t–\t–\tsynthetic\tunknown phase\n",
                "118\tOg\tOganesson\t[dz]\t18\t7\tp-block\t[294]\t(7)\t(325±15)\t(450±10)\t–\t–\t–\tsynthetic\tunknown phase"};

        for (int i = 0; i < listFromWikipedia.length; i++) {
            System.out.println(digestSingleStringForArray(listFromWikipedia[i]));
        }
        for (int i = 0; i < listFromWikipedia.length; i++) {
            System.out.println(digestSingleStringForFunction(listFromWikipedia[i]));
        }
    }

    public static String digestSingleStringForArray(String elementData) {
        String[] data = elementData.split("\t");
        String elementSymbol = data[1];
        String elementName = data[2];
        String atomicNumber = data[0];
        String atomicWeight = data[7];

        int atomicNumberProcessed = Integer.parseInt(atomicNumber);
        double atomicWeightProcessed;
        if (atomicWeight.charAt(0) == '[') {
            atomicWeightProcessed = Double.parseDouble(atomicWeight.substring(1, atomicWeight.indexOf(']')));
        }
        else {
            atomicWeightProcessed = Double.parseDouble(atomicWeight);
        }

        return "\t\tnew Element(\"" + elementSymbol + "\", \"" + elementName + "\", " + atomicNumberProcessed + ", " + atomicWeightProcessed + "),";
    }

    public static String digestSingleStringForFunction(String elementData) {
        String[] data = elementData.split("\t");
        String elementSymbol = data[1];
        String elementName = data[2];
        String atomicNumber = data[0];

        return "\t\t\tcase \"" + elementSymbol.toLowerCase() + "\", \"" + elementSymbol + "\", \"" + elementName.toLowerCase() + "\", \"" + elementName + "\":\n\t\t\t\treturn elements[" + atomicNumber + "];";
    }
}
