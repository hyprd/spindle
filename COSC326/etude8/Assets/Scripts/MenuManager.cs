using System.Collections;
using System.Collections.Generic;
using UnityEngine.SceneManagement;
using UnityEngine;

public class MenuManager : MonoBehaviour
{

    private bool loading = false;

    public void loadRoutingScene(){
        if(!loading){
            StartCoroutine(WaitAndLoad(2.0f, "Routing"));
        }
    }
    public void exitScene(){
        if(!loading){
            StartCoroutine(WaitAndLoad(0.0f, "Landing"));
        }
    }

    public void loadPacketScene(){
        if(!loading){
            StartCoroutine(WaitAndLoad(2.0f, "Encapsulation"));
        }
    }

    public void QuitApplication(){
        Application.Quit();
    }

    public IEnumerator WaitAndLoad(float waitTime, string src){
        loading = true;
        yield return new WaitForSeconds(waitTime);
        SceneManager.LoadScene(src);
    }
}
