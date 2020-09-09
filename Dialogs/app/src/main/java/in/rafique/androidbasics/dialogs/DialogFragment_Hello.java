package in.rafique.androidbasics.dialogs;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogFragment_Hello extends DialogFragment {
    Context context ;

    public static DialogFragment_Hello getInstance(String someData){
        DialogFragment_Hello dialogFragment_hello = new DialogFragment_Hello() ;
        Bundle bundle = new Bundle() ;
        bundle.putString("data", someData);
        dialogFragment_hello.setArguments(bundle);
        return dialogFragment_hello ;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialogfragment_hello, container, false) ;
    }

    @Override
    public void onStart() {
        super.onStart();
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        //not doing this can certainly make your dialog faster, but can be really fuck up your layout
        // so better make sure that your custom layout needs dialogFragment and can't be done in normal customDialog
        getDialog().getWindow().setLayout((8*width)/10, WindowManager.LayoutParams.WRAP_CONTENT);
//        getDialog().getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setCancelable(true);
        context = getActivity() ;

        Button postiveButton = view.findViewById(R.id.dialogFragmentHello_Btn_Positive) ;
        Button negativeButton = view.findViewById(R.id.dialogFragmentHello_Btn_Negative) ;

        postiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Positive button was nuked", Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });

        negativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Negative button was nuked", Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });

    }


}
